package lintcode;

import java.util.Stack;

public class DeleteDigits {
	
    public String DeleteDigits(String A, int k) {
        // write your code here
        
        Stack<Character> stack = new Stack<Character>();
        
        int popCount = 0;
        for(int i = 0; i < A.length(); i++) {
            char cur = A.charAt(i);
            
            // pop the numbers larger than cur
            while(!stack.isEmpty() && popCount < k) {
                char peek = stack.peek();
                if(peek > cur) {
                    stack.pop();
                    popCount++;
                } else break;
            }
            
            stack.push(cur);
        }
        
        String ans = "";
        while(!stack.isEmpty()) {
            ans =  stack.pop() + ans;
        }
        ans = ans.substring(0, A.length() - k);
        
        int index = 0;
        for(index = 0; index < ans.length(); index++) {
            if(ans.charAt(index) != 0) break;
        }
        
        ans = ans.substring(index, ans.length());
        if(ans.length() == 0) return "0";
        else return ans;
    }
	
//    public String DeleteDigits(String A, int k) {
//        // write your code here
//        StringBuffer sb = new StringBuffer();
//        
//        char[] arr = A.toCharArray();
//        
//        int len = arr.length - k;
//        
//        int start = -1;
//        
//        for(int i = 0; i < len ; i++) {
//            start = findMin(arr, start, i + k );
//            sb.append(arr[start]);
//        }
//        
//        
//        return sb.toString();
//    }
//    
//    private int findMin(char[] arr, int start, int end) {
//        char val = '9';
//        int index = -1;
//        for(int i = start + 1; i <= end; i++) {
//            if(index == -1 || arr[i] < val) {
//                val = arr[i];
//                index = i;
//            }
//        }
//        return index;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DeleteDigits so = new DeleteDigits();
		
		System.out.println ( so.DeleteDigits("123456789", 1)  ) ;
	}

}
