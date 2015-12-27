package lintcode.dp;

public class BackPack {
	
//	// This approach allows fetching each item unlimited times
//    public int backPack(int m, int[] A) {
//        // write your code here
//        if(A == null || A.length < 1) return 0;
//        
//        boolean[] dp1 = new boolean[m + 1];
//        dp1[0] = true;
//        
//        
//        for(int i = 1; i <= A.length; i++) {
//        	for(int j = 1; j <= m; j++) {
//        		int weight = A[i - 1];
//            
//                if(j - weight >= 0) {
//                    dp1[j] |= dp1[j - weight];
//                }
//            }
//        }
//        
//        for(int j = m; j >= 0; j--) {
//            if(dp1[j]) {
//                return j;
//            }
//        }
//        
//        return 0;
//    }
    
    // This approach only allow using each item once
    // In the inner loop, it starts at end, instead of start
    // To make sure each item will be used only once
    public int backPack(int m, int[] A) {
        // write your code here
       if(A == null) return 0;
        
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        
        for(int j = 1; j <= A.length; j++) {
            for(int i = m; i >= 0; i--) {
                
                if(i - A[j - 1] >= 0) {
                    dp[i] |= dp[i - A[j - 1]];
                }
            }
        }
        
        for(int k = m; k >= 0; k--) {
            if(dp[k]) return k;
        }
        
        return 0;
    }
	
	
//    public int backPack(int m, int[] A) {
//        // write your code here
//       if(A == null) return 0;
//        
//        boolean[][] dp = new boolean[A.length + 1][m + 1];
//        dp[0][0] = true;
//        
//        for(int j = 1; j <= A.length; j++) {
//            for(int i = 0; i <= m; i++) {
//                dp[j][i] = dp[j - 1][i];
//                if(i - A[j - 1] >= 0) {
//                    dp[j][i] |= dp[j - 1][i - A[j - 1]];
//                }
//            }
//        }
//        
//        for(int k = m; k >= 0; k--) {
//            if(dp[A.length][k]) return k;
//        }
//        
//        return 0;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackPack b = new BackPack();
		
		int[] A = {3,4,8,5};
		
		System.out.println(b.backPack(10, A));
	}

}
