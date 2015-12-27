package lintcode.dp;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
        if(s == null) return false;
        
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        int maxLen = maxLen(dict);
        
        dp[0] = true;
        for(int i = 1; i <= len; i++) {
            for(int j = ( 0 >= i - maxLen ? 0 : i - maxLen ); j < i; j++) {
            	if(!dp[j]) continue;
            	
                String w = s.substring(j, i);
                if(dict.contains(w)) {
                    dp[i] |= dp[j];
                }
    
            }
        }
        
        return dp[len];
    }
    
    private int maxLen(Set<String> dict) {
        int len = 0;
        for(String s : dict) {
            len = Math.max(len, s.length());
        }
        return len;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak so = new WordBreak();
		
		Set<String> set = new HashSet<String>();
		set.add("a"); set.add("b");
//		set.add("abcd");
//		set.add("efg");
//		set.add("bc");
//		set.add("cd");
//		set.add("de");
//		set.add("fg");
		
		boolean flag = so.wordBreak("ab", set);
		
		System.out.println(flag);
		
	}

}
