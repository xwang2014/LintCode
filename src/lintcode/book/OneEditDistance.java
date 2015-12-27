package lintcode.book;

public class OneEditDistance {
	
	/*
	 * Given two strings S and T, determine if 
	 * they are both one edit distance apart.
	 * 
	 * http://www.cnblogs.com/higerzhang/p/4185887.html
	 */
	
	
	// DP is not the best solution
	public boolean isOneEditDistance(String s, String t) {
		if(s == null || t == null) return false;
		if(Math.abs(s.length() - t.length()) > 1) return false;
		
		int[][] f = new int[s.length() + 1][t.length() + 1];
		for(int i = 0; i <= s.length(); i++) {
			f[i][0] = i;
		}
		for(int j = 0; j <= t.length(); j++) {
			f[0][j] = j;
		}
		
		// f[i][j] = s[i] == t[j] ? f[i - 1][j - 1] : 
		//  	min(f[i - 1][j - 1], f[i][j - 1], f[i - 1][j]) + 1 
		
		for(int i = 1; i <= s.length(); i++) {
			for(int j = 1; j <= t.length(); j++ ) {
				char cs = s.charAt(i - 1);
				char ct = t.charAt(j - 1);
				
				if(cs == ct) {
					f[i][j] = f[i - 1][j - 1];
				} else {
					int min = Math.min(f[i][j - 1], 
							Math.min(f[i - 1][j], f[i - 1][j - 1]));
					
					f[i][j] = min + 1;
				}
			}
		}
		
		return (f[s.length()][t.length()] == 1);
	}

	
	
	public static void main(String[] args) {
		
	}

}
