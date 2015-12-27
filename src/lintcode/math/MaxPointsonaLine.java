package lintcode.math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import lintcode.Point;

public class MaxPointsonaLine {
	
    public int maxPoints(Point[] points) {
        // Write your code here
        
        if(points == null || points.length < 1) return 0;
        if(points.length <= 2) return points.length;
        
        Arrays.sort(points, new Comparator<Point>() {
           public int compare(Point t1, Point t2) {
               if(t1.x > t2.x) return 1;
               if(t1.x < t2.x) return -1;
               return t1.y - t2.y;
           } 
        });
        
        
        int maxCnt = 0;
        for(int i = 0; i < points.length - 1; i++) {
            Point one = points[i];
            int count = 2;
            
            int k = i + 1;
            // duplicates
            while(k < points.length && points[k].x == one.x 
                && points[k].y == one.y) {
                    count++;
                    k++;
            }
            
            // same x coordinate
            while(k < points.length && points[k].x == one.x) {
            	k++;
            }
            
            if(k == points.length) continue;

            // 
            HashMap<Float, Integer> map = new HashMap<Float, Integer>();
         
            for(int j = k; j < points.length; j++) {
            	Point two = points[j];
            	float slope = (float)(one.y - two.y) / ((float)(one.x - two.x));
            	if(map.containsKey(slope)) {
            		map.put(slope, map.get(slope) + 1);
            	} else {
            		map.put(slope, count);
            	}
            }
            
            for(float f : map.keySet()) {
                count = Math.max(count, map.get(f));
            }
            
            maxCnt = Math.max(maxCnt, count); 
        }
        
        // y == 0
        for(int i = 0; i < points.length - 1; i++) {
            int cnt = 1;
            int j = i + 1;
            while(j < points.length && points[j].x == points[i].x) {
                cnt++;
                j++;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        
        return maxCnt;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] ps = new Point[4];
		
		ps[0] = new Point(0,0);
		ps[1] = new Point(0,0);
		ps[2] = new Point(1,1);
		ps[3] = new Point(2,2);
		
		
		MaxPointsonaLine so = new MaxPointsonaLine();
		int i = so.maxPoints(ps);
		
		System.out.println(i);
	}

}
