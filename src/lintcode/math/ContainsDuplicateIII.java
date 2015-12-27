package lintcode.math;

import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicateIII {
	
	/* LTE
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length <= 1) return false;
        if(k == 0) return false;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
                public int compare(Integer i1, Integer i2) {
                    if(i2 > i1) return 1;
                    if(i2 < i1) return -1;
                    return 0;
                }
            }
            );
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
            minHeap.offer(nums[i]);
            
            if(maxHeap.size() > 1) {
                int diff = Math.abs(maxHeap.peek() - minHeap.peek());
                if(diff <= t) return true;
            }
            
            if(maxHeap.size() >= k + 1) {
                maxHeap.remove(nums[i - k]);
                minHeap.remove(nums[i - k]);
            }
        }
        
        return false;
    }
    */
    
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length <= 1) return false;
        if(k == 0) return false;
        
        
        TreeSet<Long> set = new TreeSet<Long>();
        
        for(int i = 0; i < nums.length; i++) {
        	Long n = (long) nums[i];
        	
        	Long ceil = set.ceiling(n - t);
        	Long floor = set.floor(n + t);
        	
        	if( (ceil != null && ceil <= n + t) ||
        		(floor != null && floor >= n - t)) {
        		return true;
        	}
	        	
        	if(set.size() == k) {
        		set.remove(nums[i - k]);
        	}
        	set.add(n);
        }
        
        return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainsDuplicateIII so = new ContainsDuplicateIII();
		
		int[] arr = { 0,2147483647 }; 
		boolean f = so.containsNearbyAlmostDuplicate(arr, 1, 2147483647);
		System.out.println(f);
	}

}
