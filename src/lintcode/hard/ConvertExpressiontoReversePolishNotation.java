package lintcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class ConvertExpressiontoReversePolishNotation {
	
	private boolean prior(String op1, String op2) {
		if(op1.equals("(")) return false;
		if(op2.equals("(")) return false;
		
		if(op1.equals("*") || op1.equals("/")) return true;
		
		if(op2.equals("*") || op2.equals("/")) return false;
		
		if(op2.equals("+") || op2.equals("-")) return true;
		
		return true;
	}
	
    public ArrayList<String> convertToRPN(String[] expression) {
        // write your code here
    	ArrayList<String> ans = new ArrayList<String>();
    	if(expression == null || expression.length < 1) return ans;
    	
    	Stack<String> output = new Stack<String>();
    	Stack<String> operator = new Stack<String>();
    	
    	for(String cur : expression) {
    		if(cur.equals("+")) {
    			while(!operator.isEmpty() && 
    					prior(operator.peek(), cur)) {
    				output.push(operator.pop());
    			}
    				
    			operator.push(cur);
    		} else if(cur.equals("-")) {
    			while(!operator.isEmpty() && 
    					prior(operator.peek(), cur)) {
    				output.push(operator.pop());
    			}
    				
    			operator.push(cur);
    		} else if(cur.equals("*")) {
    			while(!operator.isEmpty() && 
    					prior(operator.peek(), cur)) {
    				output.push(operator.pop());
    			}
    				
    			operator.push(cur);
    		} else if(cur.equals("/")) {
    			while(!operator.isEmpty() && 
    					prior(operator.peek(), cur)) {
    				output.push(operator.pop());
    			}
    				
    			operator.push(cur);
    		} else if(cur.equals("(")) {
    				
    			operator.push(cur);
    		} else if(cur.equals(")")) {
    			while(!operator.isEmpty() && 
    					!operator.peek().equals("(")) {
    				output.push(operator.pop());
    			}
    			if(operator.peek().equals("(")) {
    				operator.pop(); 	
    			}
    			
    		} else { // number
    			output.push(cur);
    		}
    	}
    	
    	while(!operator.isEmpty()) {
    		output.push(operator.pop());
    	}
    	
    	while(!output.isEmpty()) {
    		ans.add(output.pop());
    	}
    	
    	Collections.reverse(ans);
    	
    	return ans;
    }
    
    
    

	public static void main(String[] args) {
		// "3", "-", "(", "4", "+", "5", ")"
		// "3", "-", "4", "+", "5"
		String[] expression = {"3", "-", "(", "4", "+", "5", ")"};
		
		ConvertExpressiontoReversePolishNotation so = 
				new ConvertExpressiontoReversePolishNotation();
		
		ArrayList<String> ans = so.convertToRPN(expression);
		System.out.println(ans);
	}

}
