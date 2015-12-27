package lintcode.dp;

import java.util.ArrayList;

public class MaximumSubarrayDifference {
	
//    public int maxDiffSubArrays(ArrayList<Integer> nums) {
//        // write your code
//        if(nums == null || nums.size() <= 1) return 0;
//        
//        int[] leftMax = new int[nums.size()]; //left[i] contains nums[i]
//        int[] rightMin = new int[nums.size()]; //right[i] doesnt contain nums[i]
//        int[] leftMin = new int[nums.size()];
//        int[] rightMax = new int[nums.size()];
//        
//        
//        int maxSum = nums.get(0), minSum = nums.get(0);
//        leftMax[0] = maxSum;
//        leftMin[0] = minSum;
//        // calulate leftMax, leftMin
//        for(int i = 1; i < nums.size(); i++) {
//            if(maxSum < 0) maxSum = 0;
//            maxSum += nums.get(i);
//            leftMax[i] = Math.max(leftMax[i -1], maxSum);
//            
//            if(minSum > 0) minSum = 0;
//            minSum += nums.get(i);
//            leftMin[i] = Math.min(leftMin[i - 1], minSum);
//        }
//        
//        int n = nums.size();
//        maxSum = nums.get(n - 1);
//        minSum = nums.get(n - 1);
//        rightMax[n - 1] = maxSum;
//        rightMin[n - 1] = minSum;
//        for(int i = n - 2; i >= 0; i--) {
//            if(maxSum < 0) maxSum = 0;
//            maxSum += nums.get(i );
//            rightMax[i] = Math.max(rightMax[i + 1], maxSum);
//            
//            if(minSum > 0) minSum = 0;
//            minSum += nums.get(i);
//            rightMin[i] = Math.min(rightMin[i + 1], minSum);
//        }
//        
//        // left max - right min
//        int maxDiff = 0;
//        for(int i = 0; i < n - 1; i++) {
//            maxDiff = Math.max(maxDiff, leftMax[i] - rightMin[i + 1]);
//        }
//        
//        // rightMax - left min
//        for(int i = n - 1; i > 0; i--) {
//            maxDiff = Math.max(maxDiff, rightMax[i] - leftMin[i - 1]);
//        }
//        
//        return maxDiff;
//    }
	
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() <= 1) return 0;
        
        int[] leftMax = new int[nums.size()]; //left[i] contains nums[i]
        int[] leftMin = new int[nums.size()];
        int[] rightMin = new int[nums.size()]; 
        int[] rightMax = new int[nums.size()];       
        
        int maxSum = nums.get(0), minSum = nums.get(0);
        leftMax[0] = maxSum;
        leftMin[0] = minSum;
        // calulate leftMax, leftMin
        for(int i = 1; i < nums.size(); i++) {
            if(maxSum < 0) maxSum = 0;
            maxSum += nums.get(i);
            leftMax[i] = Math.max(leftMax[i -1], maxSum);
            
            if(minSum > 0) minSum = 0;
            minSum += nums.get(i);
            leftMin[i] = Math.min(leftMin[i - 1], minSum);
        }
        
        int maxDiff = 0;
        int n = nums.size();
        maxSum = 0;
        minSum = 0;
        //rightMax[n - 2] = maxSum;
        //rightMin[n - 2] = minSum;
        for(int i = n - 1; i > 0; i--) {
        	if(i == n - 1) {
        		maxSum = nums.get(i);
        		minSum = nums.get(i);
        	} else {
        		if(maxSum < 0) maxSum = 0;
        		maxSum += nums.get(i);

        		if(minSum > 0) minSum = 0;
        		minSum += nums.get(i);
        	}
        	
        	rightMax[i] = maxSum; 
        	rightMin[i] = minSum;
        }
        
      for(int i = 0; i < n - 1; i++) {
    	  maxDiff = Math.max(maxDiff, leftMax[i] - rightMin[i + 1]);
      }
  
	  // rightMax - left min
	  for(int i = n - 1; i > 0; i--) {
	      maxDiff = Math.max(maxDiff, rightMax[i] - leftMin[i - 1]);
	  }
        
        return maxDiff;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSubarrayDifference so = new MaximumSubarrayDifference();
		
		int[] A = {100,-2,-3,-100,-1,-50 };
		ArrayList<Integer> n = new ArrayList<Integer>();
		for(int i : A) n.add(i);
		
		int diff = so.maxDiffSubArrays(n);
		
		System.out.println(diff);
		
	}

}
