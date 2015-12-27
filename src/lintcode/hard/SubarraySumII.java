package lintcode.hard;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarraySumII {
	
//	// Memory limit exceed
//    public int subarraySumII(int[] A, int start, int end) {
//        // Write your code here
//        // brute force   n^2 
//        
//        
//        int[] leftSum = new int[A.length + 1];
//        int sum = 0;
//        for(int i = 1; i < leftSum.length; i++) {
//            sum += A[i - 1];
//            leftSum[i] = sum;
//        }
//        
//        HashMap<Integer, ArrayList<Integer>> map =
//            new HashMap<Integer, ArrayList<Integer>>();
//            
//        int ans = 0;    
//        for(int i = 0; i < leftSum.length; i++) {
//            int cur = leftSum[i];
//            if(map.containsKey(cur)) ans += map.get(cur).size();
//            
//            for(int k = start; k <= end; k++) {
//                int target = cur + k;
//                if(!map.containsKey(target)) {
//                    ArrayList<Integer> list = new ArrayList<Integer>();
//                    list.add(cur);
//                    map.put(target, list);
//                } else {
//                    map.get(target).add(cur);
//                }
//            }
//        }
//        
//        return ans;
//    }
	
	// time O(n^2)   space O(1)
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        if(A == null || A.length < 1) return 0;
        
        int ans = 0;
        for(int i = 0; i < A.length; i++) {
            int sum = 0;
            for(int j = i; j < A.length; j++) {
                sum += A[j];
                if(sum >= start && sum <= end) ans++;
            }
        }
        
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubarraySumII so = new SubarraySumII();
		int[] A = { 1,2,3,4};
		
		int ans = so.subarraySumII(A, 1, 3);
		System.out.println(ans);
	}

}
