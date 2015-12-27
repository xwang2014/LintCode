package lintcode.array;

import java.util.ArrayList;

public class ContinuousSubarraySum {
	
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
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
		// TODO Auto-generated method stub

	}

}
