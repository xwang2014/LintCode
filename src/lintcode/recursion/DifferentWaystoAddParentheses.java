package lintcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
	
    // http://yuanhsh.iteye.com/blog/2230557
    
    public List<Integer> diffWaysToCompute(String input) {
        if(input == null || input.length() == 0) {
            List<Integer> list = new ArrayList<Integer>();
            return list;
        }
        
        input = input.trim().replace("+", " + ")
                .replace("-", " - ")
                .replace("*", " * ").replaceAll("[ ]+", " ");
        String[] nums = input.split(" ");
        
        List<Integer> res = compute(nums, 0, nums.length - 1);
        
        return res;
    }
    
    private List<Integer> compute(String[] nums, int start, int end) {
        List<Integer> list = new ArrayList<Integer>();
        if(start == end) {
            int v = Integer.parseInt(nums[start]);
            list.add(v);
            return list;
        }
        
        
        for(int i = start; i <= end; i++) {
            String cur = nums[i];

            if(!isOperator(cur)) continue;
            
            List<Integer> ones = compute(nums, start, i - 1);
            List<Integer> twos = compute(nums, i + 1, end);
            
            for(int one : ones) {
                for(int two : twos) {
                    int v = 0;
                    if(cur.equals("+")) {
                         v = one + two;
                    } else if(cur.equals("-")) {
                         v = one - two;
                    } else if(cur.equals("*")) {
                         v = one * two;
                    } 
                    
                    list.add(v);
                }
            }
        }
        
        return list;
    }
    
    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*");
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
