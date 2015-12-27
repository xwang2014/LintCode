package lintcode.hard;

import java.util.HashMap;

public class LongestIncreasingContinuousSubsequenceII {

    HashMap<Integer, Integer> map  = null;
   public int longestIncreasingContinuousSubsequenceII(int[][] A) {
       // Write your code here
       if(A == null || A.length == 0 || A[0].length == 0) return 0;
       
       map = new HashMap<Integer, Integer>();
       
       boolean[][] visited = new boolean[A.length][A[0].length];
       for(int i = 0; i < A.length; i++) {
           for(int j = 0; j < A[0].length; j++) {
               int fur = dfs(A, i, j, visited);
               map.put(A[i][j], fur);
           }
       }
       
       int len = 0;
       for(int i : map.keySet()) {
           int l = map.get(i);
           len = Math.max(len, l);
       }
       return len;
   }
   
   private int dfs(int[][] A, int x, int y, boolean[][] visited) {
       
       if(map.containsKey(A[x][y])) {
    	   return map.get(A[x][y]);
       }

       visited[x][y] = true;
       
       int furthest = 0;
       
       if(x > 0 && !visited[x - 1][y] && A[x-1][y] > A[x][y]) {
           int temp = dfs(A, x-1, y, visited);
           furthest = Math.max(temp, furthest);
       }
       
       if(y > 0 && !visited[x][y-1] && A[x][y-1] > A[x][y]) {
           int temp = dfs(A, x, y-1, visited);
           furthest = Math.max(temp, furthest);
       }
       
       if(x < A.length - 1 && !visited[x + 1][y] && A[x+1][y] > A[x][y]) {
           int temp = dfs(A, x+1, y, visited);
           furthest = Math.max(temp, furthest);
       }

       if(y < A[0].length - 1 && !visited[x][y+1] && A[x][y+1] > A[x][y]) {
           int temp = dfs(A, x, y+1, visited);
           furthest = Math.max(temp, furthest);
       }        
       
       
       
       visited[x][y] = false;
       return furthest + 1;
   }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LongestIncreasingContinuousSubsequenceII so = 
				new LongestIncreasingContinuousSubsequenceII();
		
		int[][] A = { 
			{1,2,3,4,5,6},
			{14,15,16,17,18,8},{12,13,11,10,9,7}	
		};
		
		int ans = so.longestIncreasingContinuousSubsequenceII(A);
		System.out.println(ans);
	}

}
