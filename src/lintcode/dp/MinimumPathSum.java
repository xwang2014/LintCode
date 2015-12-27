package lintcode.dp;

public class MinimumPathSum {
	
    public int minPathSum(int[][] grid) {
        //
        if(grid == null || grid.length == 0 ||
            grid[0] == null || grid[0].length == 0) {
                return 0;
        }
            
        // state
        int[] dp = new int[grid[0].length];
        for(int i = 0; i < dp.length; i++) dp[i] = 0;
        
        // init
        dp[0] = grid[0][0];
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(i == 0 && j == 0) continue;
                
                int left = Integer.MAX_VALUE;
                if(j > 0) {
                    left = dp[j - 1];
                }
                int up = Integer.MAX_VALUE;
                if(i > 0) {
                    up = dp[j];
                }
                
                dp[j] = ( left < up ? left : up ) + grid[i][j];
            }
        }
        
        return dp[dp.length - 1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { {1, 2}, {1, 1} };
		
		MinimumPathSum s = new MinimumPathSum();
		int res = s.minPathSum(grid);
		
		System.out.println(res);
				
	}

}
