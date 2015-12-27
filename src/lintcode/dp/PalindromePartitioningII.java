package lintcode.dp;

public class PalindromePartitioningII {
	
    public int minCut(String s) {
        // write your code here
        if(s == null || s.length() == 0) return 0;
        
        int len = s.length();
        boolean[][] map = new boolean[len][len];
       
//        for(int i = len - 1; i >= 0; i--) {
//            for(int j = i; j < len; j++) {

        for(int i = 0; i < len; i++) {
            for(int j = i; j >= 0; j--) {
                if(j == i) {
                    map[j][i] = true;
                    continue;
                }
                
                map[j][i] = ((s.charAt(j) == s.charAt(i)) &&
                    ((j + 1 <= i - 1) ? map[j+1][i-1] : true) );
            }
        }
        
        // f[i] mean min palin string in [0, i]
        int[] f = new int[len];
        
        
        for(int i = 0; i < len; i++) {
            f[i] = i + 1;

            for(int j = i; j >= 0; j--) {
                
                if(map[j][i]) {
                    f[i] = Math.min(f[i], (j > 0 ? f[j - 1] : 0) + 1);
                }                
            }
        }
        
        return f[len - 1 ] - 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioningII so = new PalindromePartitioningII();
		
		int c = so.minCut("ab");
		
		System.out.println(c);
		
	}

}
