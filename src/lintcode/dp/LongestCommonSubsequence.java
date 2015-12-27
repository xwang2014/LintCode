package lintcode.dp;

public class LongestCommonSubsequence {
	
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A == null || B == null) return 0;
        
        // state
        int[][] f = new int[A.length() + 1][B.length() + 1];
        
        // init
        //f[0][0] = 0;
        
        // function
        for(int i = 1; i <= A.length(); i++) {
            for(int j = 1; j <= B.length(); j++) {
                char a = A.charAt(i - 1);
                char b = B.charAt(j - 1);
                
                if(a == b) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j - 1], f[i][j - 1]);
                    f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                }
            }
        }
        
        
        // ans
        return f[A.length()][B.length()];
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "bedaacbade", B = "dccaeedbeb";
		
		LongestCommonSubsequence so = new LongestCommonSubsequence();
		
		int len = so.longestCommonSubsequence(A, B);
		
		System.out.println(len);

	}

}
