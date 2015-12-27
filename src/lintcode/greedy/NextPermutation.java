package lintcode.greedy;

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
	// refer: http://fisherlei.blogspot.com/2012/12/leetcode-next-permutation.html
    public int[] nextPermutation(int[] nums) {
        // write your code here
        
    	boolean found = false;
    	int i = nums.length - 1;
    	for(i = nums.length - 2; i >= 0; i--) {
    		if(nums[i] < nums[i + 1]) {
    			found = true;
    			break;
    		}
    	}
       
    	if(found) {
	    	int j = nums.length - 1;
	    	for(j = nums.length - 1; j > i; j--) {
	    		if(nums[j] > nums[i]) {
	    			break;
	    		}
	    	}
    	
	    	int temp = nums[i];
	    	nums[i] = nums[j];
	    	nums[j] = temp;
	    	
	    	int left = i + 1, right = nums.length - 1;
	    	while(left < right) {
	    		temp = nums[left];
	    		nums[left] = nums[right];
	    		nums[right] = temp;
	    		left++;
	    		right--;
	    	}
	    	
    	} else {
    		int left = 0, right = nums.length - 1;
	    	while(left < right) {
	    		int temp = nums[left];
	    		nums[left] = nums[right];
	    		nums[right] = temp;
	    		left++;
	    		right--;
	    	}
    	}
    	
    	return nums;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NextPermutation so = new NextPermutation();
		
		int[] nums = {1,3,6,3 };
		
		int[] ans = so.nextPermutation(nums);
		
		for(int i : ans) {
			System.out.print(i + "  ");
		}
	}

}
