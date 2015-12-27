package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	
	
	
    //http://blog.csdn.net/u013027996/article/details/48713751
    
    List<String> list = null;
    public List<String> addOperators(String num, int target) {
        list = new ArrayList<String>();
        if(num == null || num.length() == 0) return list;
        
        helper(num, target, 0, "", 0, 0);
        
        return list;
    }
    
    private void helper(String num, int target, int pos, String path,
        long lastNum, long sum) {
        
        if(pos == num.length()) {
            if(sum == target) {
                list.add(path);
            }
            return;
        }
        
        for(int i = pos; i < num.length(); i++) {
            if(num.charAt(pos) == '0' && i > pos) break;
            
            long curNum = Long.parseLong( num.substring(pos, i + 1) );
            
            if(pos == 0) {
                helper(num, target, i + 1, path + "" + curNum, curNum,  curNum);
            } else {
                helper(num, target, i + 1, path + "+" + curNum, curNum, sum + curNum);
                
                helper(num, target, i + 1, path + "-" + curNum, -curNum, sum - curNum);
                
                helper(num, target, i + 1, path + "*" + curNum, lastNum * curNum, sum - lastNum + lastNum * curNum);
            }
            
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionAddOperators so = new ExpressionAddOperators();
		
		
		
		
		List<String> ans = so.addOperators("3456237490", 9191);
		
		System.out.println(ans);
	}

}
