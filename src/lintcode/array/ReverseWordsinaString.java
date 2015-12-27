package lintcode.array;

/**
 * 
 * Given an input string, reverse the string word by word.
	word is seperated by space.
	For example,
	Given s = "the sky is blue",
	return "blue is sky the".
 * @author xin
 *
 */

public class ReverseWordsinaString {
    // "   "   ->  ""
    // " a    b" -> "b a"
    // "hi!"  -> "hi!"
    public String reverseWords(String s) {
        if(s == null) return s;
        s = s.trim().replaceAll("[ ]+", " ");
        if(s.length() <= 1) return s;
        
        char[] arr = s.toCharArray();
        int start = 0, end = 0;
        for(int i = 0; i < arr.length; i++) {
            if(isLetter(arr[i])) {
                end++;
            } else {
                reverse(arr, start, end - 1);
                start = i + 1;
                end = i + 1;
            }
        }
        reverse(arr, start, end - 1);
        
        reverse(arr, 0, arr.length - 1);
        
        String ans = new String(arr);
        return ans;
    }
    
    private boolean isLetter(char c) {
        if(c == ' ') return false;
        else return true;
    }
    
    
    private void reverse(char[] arr, int start, int end) {
        if(start >= end) return;
        
        while(start < end) {
            char c = arr[start];
            arr[start] = arr[end];
            arr[end] = c;
            start++;
            end--;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsinaString so = new ReverseWordsinaString();
		
		String str = "this is     a";
		String ans = so.reverseWords(str);
		System.out.println(ans);
	}

}
