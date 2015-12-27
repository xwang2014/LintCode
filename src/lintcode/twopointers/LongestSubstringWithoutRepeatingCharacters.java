package lintcode.twopointers;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

	
    public int lengthOfLongestSubstring(String s) {
        // write your code here
    	if(s == null || s.length() < 1) return 0;
    	
    	int maxLen = 0;
    	
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	int left = 0, right = 0;

    	while(right < s.length()) {
    		char c = s.charAt(right);
    		
    		if(!map.containsKey(c)) {
    			map.put(c, right);
    			
    			int curLen = right - left + 1;
    			maxLen = Math.max(curLen, maxLen);
    		} else {
    			int lastIndex = map.get(c);
    			for(int j = left; j <= lastIndex; j++) {
    				char temp = s.charAt(j);
    				map.remove(temp);
    			}
    			left = lastIndex + 1;
    			map.put(c, right);
    		}
    		right++;
    	}
    	
    	return maxLen;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters so =
				new LongestSubstringWithoutRepeatingCharacters();
		
		String s = "abcabcbb";
		int t = so.lengthOfLongestSubstring(s);
		
		System.out.println(t);
	}

}
