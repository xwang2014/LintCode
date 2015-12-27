package lintcode.array;

import java.util.ArrayList;

public class ContinuousSubarraySumII {
	
	public ArrayList<Integer> continuousSubarraySumII(int[] A) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if(A == null || A.length < 1) return ans;
		
		// find non circular best num
		ArrayList<Integer> nonOverlap = continuousSubarraySum(A);
		int start = nonOverlap.get(0), end = nonOverlap.get(1);
		
		if(start == 0 && end == A.length - 1) return nonOverlap;
		
		int nonCirSum = 0;
		for(int i = nonOverlap.get(0); i <= nonOverlap.get(1); i++) {
			nonCirSum += A[i];
		}
		
		// find curcular best num
		// best subarray starting from index 0
		
		int[] lefts = new int[A.length];
		int[] leftsIndex = new int[A.length];
		leftsIndex[0] = -1; leftsIndex[1] = 0;
		lefts[1] = A[0];
		int sum = A[0];
		for(int k = 2; k < A.length; k++) {
			sum += A[k - 1];
			if(sum >= lefts[k - 1]) {
				lefts[k] = sum;
				leftsIndex[k] = k - 1;
			} else {
				lefts[k] = lefts[k - 1];
				leftsIndex[k] = leftsIndex[k - 1];
			}
			
		}
		
		// best subarray ending with index n-1
		int[] rights = new int[A.length];
		rights[A.length - 2] = A[A.length - 1];
		
		int[] rightsIndex = new int[A.length];
		rightsIndex[A.length - 1] = -1;
		rightsIndex[A.length - 2] = A.length - 1;
		
		sum = A[A.length - 1];
		for(int k = A.length - 3; k >= 0; k--) {
			sum += A[k + 1];
			if(sum >= rights[k + 1]) {
				rights[k] = sum;
				rightsIndex[k] = k + 1;
			} else {
				rights[k] = rights[k + 1];
				rightsIndex[k] = rightsIndex[k + 1];
			}
		}
		
		int cirSum = 0;
		int cirLeft = -1, cirRight = -1;
		for(int i = 1; i < A.length - 1; i++) {
			sum = lefts[i] + rights[i];
			if(sum > cirSum) {
				cirSum = sum;
				cirLeft = leftsIndex[i];
				cirRight = rightsIndex[i];
			}
		}
		
		if(cirSum > nonCirSum) {
			ans.add(cirRight);
			ans.add(cirLeft);
		} else {
			ans.add(start);
			ans.add(end);
		}
		

		
		return ans;
	}
	
    private ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer>  ans = new ArrayList<Integer>();
        if(A == null || A.length < 1) return ans;
        
        int start = 0, end = 0, sum = A[0];
        int maxSum = A[0], startPt = 0, endPt = 0;
        while(end < A.length - 1) {
            end++;
            int cur = A[end];
            
            
            if(cur < 0) {
                if(sum > maxSum) {
                    maxSum = sum;
                    startPt = start;
                    endPt = end - 1;
                }
            }            
            
            if(sum < 0) {
                if(sum > maxSum) {
                    maxSum = sum;
                    startPt = start;
                    endPt = end - 1;
                } 
                
                sum = 0;
                start = end;
            }

            
            sum += cur;
        }
        
        if(sum > maxSum) {
            maxSum = sum;
            startPt = start;
            endPt = end;
        }
        
        ans.add(startPt);
        ans.add(endPt);
        
        return ans;
    }

	public static void main(String[] args) {
		//int[] A = { 4, 3, -100, 1, 3, 200};
		int[] A = { 1,2,-2,-100,1,2,-2};
		
		ContinuousSubarraySumII so = new ContinuousSubarraySumII();
		
		ArrayList<Integer> ans = so.continuousSubarraySumII(A);
		
		System.out.println(ans);

	}

}
