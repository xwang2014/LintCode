package lintcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lintcode.Interval;

public class NumberofAirplanesintheSky {
	
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
    	if(airplanes == null || airplanes.size() < 1) return 0;
    	
        ArrayList<Integer> starts = new ArrayList<Integer>();
        ArrayList<Integer> ends = new ArrayList<Integer>();
        
        for(Interval inv : airplanes) {
        	starts.add(inv.start);
        	ends.add(inv.end);
        }
        Collections.sort(starts);
        Collections.sort(ends);
        
        
        int maxNum = 0, num = 0;
        int flyIdx = 0, landIdx = 0;
        while(landIdx < ends.size()) {
        	if(flyIdx == starts.size()) {
        		num--;
        		landIdx++;
        		continue;
        	}
        	
        	int fly = starts.get(flyIdx);
        	int land = ends.get(landIdx);
        	
        	if(fly < land) {
        		num++;
        		maxNum = Math.max(maxNum, num);
        		flyIdx++;
        	} else {
        		num--;
        		landIdx++;
        	}
        			
        }
        
        return maxNum;
    }
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberofAirplanesintheSky so = new NumberofAirplanesintheSky();
	}

}
