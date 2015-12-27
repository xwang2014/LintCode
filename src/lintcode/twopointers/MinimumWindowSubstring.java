package lintcode.twopointers;

import java.util.HashMap;

public class MinimumWindowSubstring {
	
	// Use O(n) algo
	// http://www.cnblogs.com/springfor/p/3872559.html
	// http://articles.leetcode.com/2010/11/finding-minimum-window-in-s-which.html
	
	
    public String minWindow(String source, String target) {
    	if(source == null || source.length() < 1 || target == null) return "";
    	
    	HashMap<Character, Integer> tar = new HashMap<Character, Integer>();
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	
    	for(int i = 0; i < target.length(); i++) {
    		char c = target.charAt(i);
    		if(!tar.containsKey(c)) {
    			tar.put(c, 1);
    		} else {
    			tar.put(c, tar.get(c) + 1);
    		}
    	}
    	
    	int start = 0, end = 0;
    	int count = 0; 
    	int minLen = Integer.MAX_VALUE;
    	String res = "";
    	
    	while(end < source.length()) {
    		char c = source.charAt(end);
    		if(!tar.containsKey(c)) {
    			end++;
    			continue;
    		}
    		
    		
    		// tar.containsKey(c) == true
    		if(!map.containsKey(c)) {
    			map.put(c, 1);
    		} else {
    			map.put(c, map.get(c) + 1);
    		}
    		
    		if(map.get(c) <= tar.get(c)) {
    			count++;
    		}
    		
    		
    		
    		// Found substring contains target
    		if(count == target.length()) {
    			
    			while(!tar.containsKey(source.charAt(start)) 
    					|| map.get(source.charAt(start)) > tar.get(source.charAt(start))) {
    				char temp = source.charAt(start);
    				if(tar.containsKey(temp) && map.get(temp) > tar.get(temp)) {
    					map.put(temp, map.get(temp) - 1);
    				}
    				start++;
    			}
    			
    			int curLen = end - start + 1;
    			if(curLen < minLen) {
    				minLen = curLen;
    				res = source.substring(start, end + 1);
    			}
    			
    			// move start forward by 1
    			char t = source.charAt(start);
    			map.put(t, map.get(t) - 1);
    			count--;
    			start++;
    		}
    		
    		end++;
    	}
    	
    	if(minLen == Integer.MAX_VALUE) {
    		return "";
    	} else {
    		return res;
    	}
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MinimumWindowSubstring so = new MinimumWindowSubstring();
		String source = "ADOBECODEBANC"; 
		String target = "ABC";
		String ans = so.minWindow(source, target);
		
		System.out.println(ans);
		
	}

}
