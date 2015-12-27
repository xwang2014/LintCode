package lintcode;

import java.util.HashMap;

public class MinimumWindowSubstring {
	
    public String minWindow(String source, String target) {
        // write your code
        if(source == null || target == null || source.length() < 1
            || target.length() < 1 || source.length() < target.length())
            return "";
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        
        String ans = null;
        int start = 0, end = 0;
        for(end = 0; end < source.length(); end++) {
        	char c = source.charAt(end);
            if(map.containsKey(c)) {
            	map.put(c, map.get(c) + 1);
            } else {
            	map.put(c, 1);
            }
            
            if(cover(map, target)) { 
                String cur = source.substring(start, end + 1);
                while(start <= end) {
                	char ch = source.charAt(start);
                	if(map.containsKey(ch)) {
                		if(map.get(ch) == 1) map.remove(ch);
                		else map.put(ch, map.get(ch) - 1);
                	}
                    start++;
                    if(cover(map, target)) {
                        cur = source.substring(start, end + 1);
                    } else {
                        break;
                    }
                }
                if(ans == null || cur.length() < ans.length()) {
                    ans = cur;
                }
            }
        }
        
        while(start < end) {
        	char ch = source.charAt(start);
        	if(map.containsKey(ch)) {
        		if(map.get(ch) == 1) map.remove(ch);
        		else map.put(ch, map.get(ch) - 1);
        	}
            start++;
            if(cover(map, target)) {
                String cur = source.substring(start, end + 1);
                if(ans == null || cur.length() < ans.length()) {
                    ans = cur;
                }                
            } else {
                break;
            }
        }        
        
        return ans == null ? "" : ans;
    }
    
    
    private boolean cover(HashMap<Character, Integer> maps, String target) {
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>(maps);
        for(int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if(!map.containsKey(c)) return false;
            if(map.get(c) == 1) map.remove(c);
            else map.put(c, map.get(c) - 1);
        }
        return true;
    }	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumWindowSubstring so = new MinimumWindowSubstring();
		
		String ans = so.minWindow("abcd", "ac");
		
		System.out.println(ans);
	}

}
