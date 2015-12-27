package lintcode.highfrequency;

public class BestTimeBuySellStockIII {
	
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length <= 1) return 0;
        
        int[] forward = new int[prices.length];
        // forward[i] mean max profit from [0, i]
        
        int[] backward = new int[prices.length];
        // backward[i] mean max profit from [i, prices.length - 1]
        
        int profit = 0;
        int curMin = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] >= curMin) {
                profit = Math.max(profit, prices[i] - curMin);
                forward[i] = profit;
            } else {
                curMin = prices[i];
                forward[i] = profit;
            }
        }
        
        profit = 0;
        int curMax = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--) {
            if(prices[i] <= curMax) {
                profit = Math.max(profit, curMax - prices[i]);
                backward[i] = profit;
            } else {
                curMax = prices[i];
                backward[i] = profit;
            }
        } 
        
        // maxprofit = forward[i] + backward[i + 1]
        int maxProfit = 0;
        for(int cut = 0; cut <= prices.length - 1; cut++) {
            int left = forward[cut];
            int right = 0;
            if(cut < prices.length - 1) right = backward[cut + 1];
            
            maxProfit = Math.max(maxProfit, left + right);
        }
        
        return maxProfit;
    }
	
//    public int maxProfit(int[] prices) {
//        // write your code here
//        if(prices == null || prices.length <= 1) return 0;
//        if(prices.length == 2 ) {
//            return Math.max(0, prices[1] - prices[0]);
//        }
//        
//        
//        // Two Transactions
//        int maxProfit = 0;
//        for(int cut = 1; cut < prices.length - 2; cut++) {
//            int left = profit(prices, 0, cut);
//            int right = profit(prices, cut + 1, prices.length - 1);
//            
//            maxProfit = Math.max(maxProfit, left + right);
//        }
//        
//        // One Transaction
//        int profit = profit(prices, 0, prices.length - 1);
//        
//System.out.println("One = " + profit + "   Two = " + maxProfit);        
//        return Math.max(profit, maxProfit);
//    }
//    
//    private int profit(int[] prices, int start, int end) {
//        if(start == end) return 0;
//        
//        int profit = 0;
//        int curMin = prices[start];
//        for(int i = start + 1; i <= end; i++) {
//            if(prices[i] >= curMin) {
//                profit = Math.max(profit, prices[i] - curMin);
//            } else {
//                curMin = prices[i];
//            }
//        }
//        return profit;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1, 2, 4};
		
		BestTimeBuySellStockIII so = new BestTimeBuySellStockIII();
		
		so.maxProfit(prices);
	}

}
