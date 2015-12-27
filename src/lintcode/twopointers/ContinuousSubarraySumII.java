package lintcode.twopointers;

import java.util.ArrayList;

public class ContinuousSubarraySumII {
	
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(A == null || A.length < 1) return res;
        
        int total = 0;
        for(int i : A) total += i;
        
        ArrayList<Integer> maxSub = maxsub(A);
        int curSum = 0;
        for(int i = maxSub.get(0); i <= maxSub.get(1); i++) {
            curSum += A[i];
        }
        
        ArrayList<Integer> minSub = minsub(A);
        int minSum = 0;
        for(int i = minSub.get(0); i <= minSub.get(1); i++) {
            minSum += A[i];
        }
        
        if(curSum >= total - minSum) {
            return maxSub;
        } else {
            int minStart = minSub.get(0);
            int minEnd = minSub.get(1);
            if(minStart > 0 && minEnd < A.length - 1) {
                res.add(minEnd + 1);
                res.add(minStart - 1);
                return res;
            } else {
                return maxSub;
            }
        }
        
    }

    private ArrayList<Integer> minsub(int[] A) {
        int sum = Integer.MAX_VALUE, start = 0, end = 0;
        int left = 0, right = 0, curSum = 0;
        
        while(right <= A.length - 1) {
            curSum += A[right];
            
            if(curSum <= sum) {
                sum = curSum;
                start = left;
                end = right;
            }
            if(curSum >= 0) {
                left = right + 1;
                curSum = 0;
            }
            
            right++;
        }
        
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(start);
        res.add(end);
        return res;
    }
    
    private ArrayList<Integer> maxsub(int[] A) {
        int sum = Integer.MIN_VALUE, start = 0, end = 0;
        int left = 0, right = 0, curSum = 0;
        
        while(right <= A.length - 1) {
            curSum += A[right];
            
            if(curSum >= sum) {
                sum = curSum;
                start = left;
                end = right;
            }
            if(curSum <= 0) {
                left = right + 1;
                curSum = 0;
            }
            
            right++;
        }
        
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(start);
        res.add(end);
        return res;
    }	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContinuousSubarraySumII so = new ContinuousSubarraySumII();
		
		int[] A = { -101,-33,-44,-55,-67,-78,-101,-33,-44,-55,-67,-78,-100,-200,-1000,-22,-100,-200,-1000,-22};
		
		ArrayList<Integer> res = so.continuousSubarraySumII(A);
		System.out.println(res);
	}

}
