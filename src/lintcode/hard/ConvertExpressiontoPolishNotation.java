package lintcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConvertExpressiontoPolishNotation {
	
	private boolean prior(String op1, String op2) {
		if(op1.equals("(")) return false;
		if(op2.equals("(")) return false;
		
		if(op1.equals("*") || op1.equals("/")) return true;
		
		if(op2.equals("*") || op2.equals("/")) return false;
		
		if(op2.equals("+") || op2.equals("-")) return true;
		
		return true;
	}
	
    public ArrayList<String> convertToPN(String[] expression) {
        // write your code here
    	ArrayList<String> ans = new ArrayList<String>();
    	
    	if(expression == null || expression.length == 0) return ans;
    	
    	Stack<ArrayList<String>> numbers = new Stack<ArrayList<String>>();
    	Stack<String> operators = new Stack<String>();
    	
    	for(int i = 0; i < expression.length; i++) {
    		String cur = expression[i];
    		if(cur.equals("+") || cur.equals("-") || cur.equals("*")
    				|| cur.equals("/")) {
    			while(!operators.isEmpty() 
    					&& prior(operators.peek(), cur)) {
    				ArrayList<String> op2 = numbers.pop();
    				ArrayList<String> op1 = numbers.pop();
    				ArrayList<String> exp = new ArrayList<String>();
    				exp.add(operators.pop());
    				exp.addAll(op1);
    				exp.addAll(op2);
    				
    				numbers.add(exp);
    			}
    			operators.push(cur);
    		
    		} else if(cur.equals("(")) {
    			operators.push(cur);
    		} else if(cur.equals(")")) {
    			while(!operators.isEmpty() 
    					&& !operators.peek().equals("(")) {
    				ArrayList<String> op2 = numbers.pop();
    				ArrayList<String> op1 = numbers.pop();
    				ArrayList<String> exp = new ArrayList<String>();
    				exp.add(operators.pop());
    				exp.addAll(op1);
    				exp.addAll(op2);
    				
    				numbers.add(exp);
    			}
    			if(operators.peek().equals("(")) operators.pop();
    			
    		} else { // numbers
    			ArrayList<String> val = new ArrayList<String>();
    			val.add(cur);
    			numbers.push(val);
    		}
    	}
    	
    	while(!operators.isEmpty()) {
			ArrayList<String> op2 = numbers.pop();
			ArrayList<String> op1 = numbers.pop();
			ArrayList<String> exp = new ArrayList<String>();
			exp.add(operators.pop());
			exp.addAll(op1);
			exp.addAll(op2);
			
			numbers.add(exp);
    	}
    	
    	if(numbers.isEmpty()) {
    		return ans;
    	} else { 
    		return numbers.pop();
    	}
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] e = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")" };
		
		ConvertExpressiontoPolishNotation so = new ConvertExpressiontoPolishNotation();
		
		ArrayList<String> ans = so.convertToPN(e);
		
		System.out.println(ans);
	}

}
