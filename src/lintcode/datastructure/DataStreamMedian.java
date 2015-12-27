package lintcode.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DataStreamMedian {
	
    public int[] medianII(int[] nums) {
        // write your code here
        PriorityQueue<Integer> minRight = new PriorityQueue<Integer>(1);
        PriorityQueue<Integer> maxLeft = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                if(i1 < i2) return 1;
                if(i1 > i2) return -1;
                return 0;
            }
        });
        
        if(nums == null) return null;
        int[] medians = new int[nums.length];
        if(nums.length == 0) return medians;
        if(nums.length == 1) return nums;
        
        maxLeft.offer(nums[0]);
        medians[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] > maxLeft.peek()) {
        		minRight.offer(nums[i]);
        	} else {
        		maxLeft.offer(nums[i]);
        	}
        	
        	rebalance(maxLeft, minRight);
        	
        	medians[i] = maxLeft.peek();
        }
        
        return medians;
    }
    
    private void rebalance(PriorityQueue<Integer> maxLeft, 
    		PriorityQueue<Integer> minRight) {
    	if(maxLeft.size() == minRight.size() || maxLeft.size() == minRight.size() + 1) {
    		return;
    	}
    	
    	while(maxLeft.size() - minRight.size() >= 2) {
    		minRight.offer(maxLeft.poll());
    	}
    	while(maxLeft.size() < minRight.size()) {
    		maxLeft.offer(minRight.poll());
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataStreamMedian so = new DataStreamMedian();
		
		int[] nums = { 4, 5, 1, 3, 2, 6, 0 };
		
		int[] ans = so.medianII(nums);
		
		for(int i : ans) {
			System.out.print(i + "  ");
		}
	}

}
