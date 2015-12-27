package lintcode.dp;

import java.util.ArrayList;

public class MaximumSubarrayIII {
	
    public int maxSubArray(ArrayList<Integer> nums, int k) {
        // write your code
        if(nums == null || nums.size() == 0) return 0;
        
        // f[i][j] first i number, j sub arrays, max sum.  i >= j
        int len = nums.size();
        int[][] f = new int[len + 1][k + 1];
        
        int sum  = 0;
        for(int i = 0; i <= len; i++) {
            for(int j = 0; j <= k; j++) {
            	if(j == 0) {
            		f[i][j] = 0;
            	} else {
            		f[i][j] = Integer.MIN_VALUE;
            	}
            }
        }
        
        // f[i][j] = f[i - 1][j] or f[p][j - 1] + maxSub(p + 1, i)
        for(int j = 1; j <= k; j++) {
        	for(int i = j; i <= len; i++) {
        		if(i - 1 >= j) f[i][j] = f[i - 1][j];
                
                for(int p = j - 1; p < i; p++) {
                    int temp = f[p][j - 1] + maxSum(nums, p + 1, i);
                    f[i][j] = Math.max(temp, f[i][j]);
                }
            }
        }
        
        return f[len][k];
    }
    
    private int maxSum(ArrayList<Integer> nums, int start, int end) {
        start--; end--;
        int sum = 0, maxVal = 0;
        for(int i = start; i <= end; i++) {
            if(i == start) {
                sum = nums.get(i);
                maxVal = sum;
            } else {
                sum += nums.get(i);
                maxVal = Math.max(maxVal, sum);
            }
            if(sum < 0) sum = 0;
        }
        return maxVal;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSubarrayIII so = new MaximumSubarrayIII();
		
		int[] n = {-1,-2, -100,-1,-50};
		ArrayList<Integer> A = new ArrayList<Integer>();
		for(int i : n) A.add(i);
		
		int ans = so.maxSubArray(A, 2);
		
		System.out.println(ans);
	}

}
