package lintcode.swipingline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lintcode.Interval;

class Edge {
    public int position;
    public boolean isStart;
    
    public Edge(int p, boolean start) {
        position = p;
        isStart = start;
    }

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
    
    
} 

class MyComparator implements Comparator<Edge> {

	@Override
	public int compare(Edge e1, Edge e2) {
           if(e1.position > e2.position) return 1;
           if(e1.position < e2.position) return -1;
           
           if(e1.isStart && !e2.isStart) return 1;
           if(!e1.isStart && e2.isStart) return -1;
           
           return 0;
	}
    
}

public class NumberofAirplanesintheSky {
	

     
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        
        if(airplanes == null || airplanes.size() == 0) return 0;
        
        List<Edge> list = new ArrayList<Edge>();
        for(Interval in : airplanes) {
            Edge start = new Edge(in.start, true);
            Edge landing = new Edge(in.end, false);
            
            list.add(start); 
            list.add(landing);
        }
        
        MyComparator mc = new MyComparator();
        
        Collections.sort(list, mc );
        
        int airs = 0;
        int count = 0;
        for(Edge e : list) {
            if(e.isStart) {
                count++;
            } else {
                count--;
            }
            
            airs = Math.max(airs, count);
        }
        
        return airs;
    }
    
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
