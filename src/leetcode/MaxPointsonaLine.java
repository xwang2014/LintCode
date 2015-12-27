package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Point {
	int x, y;
	public Point(int i, int j) {
		x = i;
		y = j;
	}
}

public class MaxPointsonaLine {
	
    public int maxPoints(Point[] points) {
        if(points == null || points.length < 1) return 0;
        if(points.length <= 2) return points.length;
        
        Arrays.sort(points, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if(p1.x < p2.x) return -1;
                if(p1.x > p2.x) return 1;
                if(p1.y < p2.y) return -1;
                if(p1.y > p2.y) return 1;
                
                return 0;
            }
        });       
        
        int globalMax = 0;
        int i = 0;
        while(i < points.length) {
        	HashMap<Float, Integer> map = new HashMap<Float, Integer>();
        	
        	int duplicate = 0;
        	int j = i;
        	
        	while(j < points.length && points[i].x == points[j].x 
        			&& points[i].y == points[j].y) {
        		duplicate++;
        		j++;
        	}
        	
        	int maxNum = 0;
            for(; j < points.length; j++) {
                Point p1 = points[i];
                Point p2 = points[j];
                
                
                if(p1.x == p2.x) {
                    if(map.containsKey(null)) {
                        map.put(null, map.get(null) + 1);
                    } else {
                        map.put(null, 1);
                    }
                    maxNum = Math.max(maxNum, map.get(null));
                } else {
                    float slope = (p1.y - p2.y) / (float)(p1.x - p2.x);
                    if(map.containsKey(slope) ) {
                        map.put(slope, map.get(slope) + 1);
                    } else {
                        map.put(slope, 1);
                    }
                    maxNum = Math.max(maxNum, map.get(slope));
                }
            }
            
            maxNum += duplicate;
            globalMax = Math.max(globalMax, maxNum);
            
            i += duplicate;
        }
        
        return globalMax;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPointsonaLine so = new MaxPointsonaLine();
		Point[] points = new Point[3];
		points[0] = new Point(0, 0);
		points[1] = new Point(-1, -1);
		points[2] = new Point(2, 2);
		
		int n = so.maxPoints(points);
		System.out.println(n);
	}

}
