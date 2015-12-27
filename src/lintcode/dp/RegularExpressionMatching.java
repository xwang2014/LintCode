package lintcode.dp;

public class RegularExpressionMatching {
    // http://bangbingsyb.blogspot.com/2014/11/leetcode-regular-expression-matching.html
    // http://articles.leetcode.com/2011/09/regular-expression-matching.html
	
    public boolean isMatch(String s, String p) {
        // write your code here
        if(s == null || p == null) return false;
        
        boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
        f[0][0] = true;
        
        for(int i = 0; i <= s.length(); i++) {
            for(int j = 1; j <= p.length(); j++) { 
            	char d = p.charAt(j - 1);
                if(d == '*') {
                    continue;
                } else if(d == '.') {
                    // match one
                	if(i > 0) {
                		f[i][j] |= f[i - 1][j - 1];
                	}
                	
                    if(j < p.length() && p.charAt(j) == '*' ) {
                        // match zero
                        f[i][j + 1] |= f[i][j - 1];
                        
                        // match multiple
                        for(int k = i + 1; k <= s.length(); k++) {
                            f[k][j + 1] |= f[i][j + 1];
                        }                        
                    }                    
                } else { // s[i] == p[j]
                    // match one
                	if(i > 0 && s.charAt(i - 1) == d) {
                		f[i][j] |= f[i - 1][j - 1];
                	}
                    
                    if(j < p.length() && p.charAt(j) == '*' ) {
                        // match zero
                        f[i][j + 1] |= f[i][j - 1];
                        
                        // match multiple
                        for(int k = i; k <= s.length(); k++) {
                            if(k > 0 && s.charAt(k - 1) != p.charAt(j - 1) ) break;
                            f[k][j + 1] |= f[i][j + 1];
                        }
                    } 
                } 
            }
        }
        
        return f[s.length()][p.length()];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpressionMatching so = new RegularExpressionMatching();
		
		String s = "bbabacccbcbbcaaab";
		String p = "b*a*c*aa*c*bc*";
		s = "baa";
		p = "b*a";
		
		boolean f = so.isMatch(s, p);
		
		System.out.println(f);
	}

}
