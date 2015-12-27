package lintcode.array;

import java.util.HashMap;

public class SubmatrixSum {
	
    // O(N^3) solution 
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        
        if(matrix == null || matrix.length == 0) return null;
        
        int startRow = 0, endRow = matrix.length - 1;
        
        for(int i = startRow; i <= endRow; i++) {
            int[] sum = new int[matrix[0].length];
            
            for(int j = i; j <= endRow; j++) {
                
                for(int t = 0; t < matrix[0].length; t++) {
                    sum[t] += matrix[j][t];
                }
                
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                map.put(0, -1);
                
                int curSum = 0;
                for(int t = 0; t < sum.length; t++) {
                    curSum += sum[t];
                    
                    if(map.containsKey(curSum)) {
                        int leftCol = map.get(curSum);
                        
                        int[][] ans = { {i, leftCol + 1 }, {j, t} };
                        
                        return ans;
                    } else {
                        map.put(curSum, t);
                    }
                }
            }
        }
        
        return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubmatrixSum so = new SubmatrixSum();
		
		int[][] arr = { 
			{1,5,7},{3,7,-8},{4,-8,9}
		};
		
		int[][] ans = so.submatrixSum(arr);
		
		for(int i = 0; i < ans.length; i++) {
			for(int j = 0; j < ans[i].length; j++) {
				System.out.println(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

}
