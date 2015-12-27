package lintcode.dp;

import java.util.ArrayList;

public class MinimumAdjustmentCost {
	
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        if(A == null || A.size() == 0) return 0;
        // f[i][v] -- first i numbers, the ith number set to v
        int maxVal = Integer.MIN_VALUE;
        for(int v : A) maxVal = Math.max(maxVal, v);
        
        int[][] f = new int[A.size()][maxVal + 1];
        
        // f[0][v] = 0;
        for(int i = 0; i < A.size(); i++) {
            for(int j = 0; j <= maxVal; j++) {
                f[i][j] = 100 * 10000;
            }
        }
        for(int i = 0; i <= maxVal; i++) {
            f[0][i] = Math.abs(A.get(0) - i);
        }
        
        
        // f[i][k] ->  f[i - 1][v] + (A[i] - k);  k -> [v +- target]
        for(int i = 1; i < A.size(); i++) {
            for(int v = 0; v <= maxVal; v++) {
                for(int k = 0; k <= maxVal; k++) {
                    if(Math.abs(k - v) > target) continue;
                    
                    f[i][k] = Math.min(f[i][k], f[i - 1][v] + Math.abs(A.get(i) - k) );
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= maxVal; i++) {
            min = Math.min(f[A.size() - 1][i], min);
        }
        return min;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumAdjustmentCost so = new MinimumAdjustmentCost();
		
		int[] n = {11,11,3,5,11,16,12,11,15,11,16,16,16,16,16,11,16};
		ArrayList<Integer> A = new ArrayList<Integer>();
		for(int i : n) A.add(i);
		
		int f = so.MinAdjustmentCost(A, 0);
		
		System.out.println(f);
	}

}
