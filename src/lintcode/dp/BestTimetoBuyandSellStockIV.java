package lintcode.dp;

public class BestTimetoBuyandSellStockIV {
	
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        
        int len = prices.length;
        int[][] profit = new int[len][len];
        
        // O(n^2) compute the profit [i,j]
        for(int i = 0; i < len; i++) {
            int min = prices[i];
            profit[i][i] = 0;
            for(int j = i + 1; j < len; j++) {
                min = Math.min(min, prices[j]);
                profit[i][j] = Math.max(profit[i][j - 1], prices[j] - min);
            }
        }
        
        
        // f[i][k] the first i prices, k transactions
        // f[i][k] = f[j][k - 1] + p[j + 1, i]     0 <= j < i-1
        int[][] f = new int[len + 1][k + 1];
        
        for(int i = 1; i <= len; i++) {
            for(int m = 1; m <= k; m++) {
                
                for(int j = 0; j <= i - 1; j++) {
                    f[i][m] = Math.max(f[i][m], f[j][m - 1] + profit[j+1 - 1][i - 1]);
                }
            }
        }
        
        return f[len][k];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1, 2};
		
		BestTimetoBuyandSellStockIV so = new BestTimetoBuyandSellStockIV();
		int v = so.maxProfit(1, prices);
		System.out.println(v);
	}

}
