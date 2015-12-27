package lintcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
	
    PriorityQueue<Integer> maxHeap = null;
    PriorityQueue<Integer> minHeap = null;
    ArrayList<Integer> res = null;
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        res = new ArrayList<Integer>();
        if(nums == null || k == 0 || nums.length < 1) return res;
        
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
           public int compare(Integer i1, Integer i2) {
               if(i1 > i2) return -1;
               if(i1 < i2) return 1;
               return 0;
           } 
        });
        
        for(int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        
        reblance();
        res.add(maxHeap.peek());   
        
        for(int i = k; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
            remove(nums[i - k]);
            reblance();
            
            res.add(maxHeap.peek());
        }
        
        return res;
    }
    
    private void remove(int i) {
        boolean flag = minHeap.remove(i);
        if(!flag) {
            maxHeap.remove(i);
        }
    }
    
    private void reblance() {
        while(!maxHeap.isEmpty() && 
        		!minHeap.isEmpty()
        		&& maxHeap.peek() >= minHeap.peek()) {
        	minHeap.offer(maxHeap.poll());
        }
            
        while(maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }    
        while(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlidingWindowMedian so = new SlidingWindowMedian();
		
		int[] A = { 1,2,7,7,2,10,3,4,5 };
		
		ArrayList<Integer> res = so.medianSlidingWindow(A, 2);
		
		for(int i : res) {
			System.out.print(i + " ");
		}
		
	}

}
