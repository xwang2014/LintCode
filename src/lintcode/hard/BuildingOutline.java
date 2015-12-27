package lintcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BuildingOutline {
	
    // https://codesolutiony.wordpress.com/2015/06/01/leetcode-the-skyline-problem-lintcode-building-outline/
    
    class Edge {
        int index;
        int height;
        boolean isStart;
        public Edge(int index, int h, boolean start) {
            this.index = index;
            height = h;
            isStart = start;
        }
    }
     
    ArrayList<ArrayList<Integer>> res = null; 
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        res = new ArrayList<ArrayList<Integer>>();
        if(buildings == null || buildings.length == 0) return res;
        
        List<Edge> edges = new ArrayList<Edge>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1,
        		new Comparator<Integer>() {
        	public int compare(Integer i1, Integer i2) {
        		if(i1 > i2) return -1;
        		if(i1 < i2) return 1;
        		return 0;
        	}
        });
        
        // Parse the buildings
        for(int i = 0; i < buildings.length; i++) {
            int startPt = buildings[i][0];
            int endPt = buildings[i][1];
            int h = buildings[i][2];
            
            Edge cStart = new Edge(startPt, h, true);
            Edge cEnd = new Edge(endPt, h, false);
            edges.add(cStart);
            edges.add(cEnd);
        }
        
        Collections.sort(edges, new Comparator<Edge>() {
           public int compare(Edge c1, Edge c2) {
               // sort by index first
               if(c1.index > c2.index) return 1;
               if(c1.index < c2.index) return -1;
               // make start before end
               if(c1.isStart && !c2.isStart) return -1;
               if(c2.isStart && !c1.isStart) return 1;
               
               // sort by height
               if(c1.height > c2.height) return -1;
               if(c2.height > c1.height) return 1;
               return 0;
           } 
            
        });
        
        // iterate the edges list
        int h = 0, start = -1;
        for(int i = 0; i < edges.size(); i++) {
            Edge cur = edges.get(i);
            
            if(cur.isStart) {
            	maxHeap.offer(cur.height);
            	
            	if(start == -1) {
            		start = cur.index;
            		h = cur.height;
            	}
            	if(h < maxHeap.peek()) {
            	    if(start != cur.index) {
                		ArrayList<Integer> list = new ArrayList<Integer>();
                		list.add(start);
                		list.add(cur.index);
                		list.add(h);
                		res.add(list);
            	    }
            		
            		h = maxHeap.peek();
            		start = cur.index;
            	}
            } else {
                maxHeap.remove(cur.height);
                
                if(maxHeap.isEmpty() || h > maxHeap.peek()) {
                    if(start != cur.index) {
                		ArrayList<Integer> list = new ArrayList<Integer>();
                		list.add(start);
                		list.add(cur.index);
                		list.add(h);
                		res.add(list);
                    }
            		
            		if(maxHeap.isEmpty()) {
            			h = 0;
            			start = -1;
            		} else {
            			h = maxHeap.peek();
            			start = cur.index;
            		}
                }
            }
            
            
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] buildings = { {1,3,3},{2,4,4},{5,6,1} }; 
		
		BuildingOutline so = new BuildingOutline();
		ArrayList<ArrayList<Integer>> res = so.buildingOutline(buildings);
		
		System.out.println(res);
	}

}
