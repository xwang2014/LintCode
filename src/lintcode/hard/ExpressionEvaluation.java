package lintcode.hard;

import java.util.Stack;

public class ExpressionEvaluation {
	/*
    private int getResult(int n1, int n2, String op) {
        if(op.equals("*")) return n1 * n2;
        if(op.equals("/")) return n1 / n2;
        if(op.equals("+")) return n1 + n2;
        if(op.equals("-")) return n1 - n2;
        return 0;
    } 
    
    private boolean prior(String op1, String op2) {
        if(op2.equals("*") || op2.equals("/")) return false;
        
        if(op1.equals("*") || op1.equals("/")) return true;
        if(op2.equals("(")) {
        	return true;
        }
        else return false;
    }
     
    public int evaluateExpression(String[] expression) {
        if(expression == null || expression.length < 1) return 0;
        
        // () prior to * /  prior to + -
        
        Stack<String> operator = new Stack<String>();
        Stack<Integer> num = new Stack<Integer>();
        
        for(int i = 0; i < expression.length; i++) {
            String cur = expression[i];
            if(cur.equals("+") || cur.equals("-")) {
                while(!operator.isEmpty() && 
                    !prior(cur, operator.peek()) ) {
                        int n2 = num.pop();
                        int n1 = num.pop();
                        String op = operator.pop();
                        int res = getResult(n1, n2, op);
                        num.push(res);
                }
                operator.push(cur);
            } else if(cur.equals("*")) {
                while(!operator.isEmpty() && 
                    !prior(cur, operator.peek()) ) {
                        int n2 = num.pop();
                        int n1 = num.pop();
                        String op = operator.pop();
                        int res = getResult(n1, n2, op);
                        num.push(res);
                }
                operator.push(cur);
            } else if(cur.equals("/")) {
                while(!operator.isEmpty() && 
                    !prior(cur, operator.peek()) ) {
                        int n2 = num.pop();
                        int n1 = num.pop();
                        String op = operator.pop();
                        int res = getResult(n1, n2, op);
                        num.push(res);
                }                
                operator.push(cur);
            } else if(cur.equals("(")) {
                operator.push(cur);
            } else if(cur.equals(")")) {
                while( 
                    !operator.peek().equals("(")) {
                    String op = operator.pop();
                    int n2 = num.pop();
                    int n1 = num.pop();
                    int res = getResult(n1, n2, op);
                    num.push(res);        
                }
                operator.pop();
            } else { // number
                int n = Integer.parseInt(cur);
                num.push(n);
            }
        }
        
        while(!operator.isEmpty()) {
            int n2 = num.pop();
            int n1 = num.pop();
            String op = operator.pop();
            num.push(getResult(n1, n2, op));
        }
        
        if(num.isEmpty()) return 0;
        else return num.pop();
    }
    
    */

    private boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") ||
            c.equals("*") || c.equals("/");  
    }
    
    private int compute(int num1, int num2, String op) {
        if(op.equals("+")) {
            return num1 + num2;
        } else if(op.equals("-")) {
            return num1 - num2;
        } else if(op.equals("*")) {
            return num1 * num2;
        } else if(op.equals("/")) {
            return num1 / num2;
        }  else return 0;
    }
    
    private int priority(String op1, String op2) {
        if(op1.equals("*") || op1.equals("/")) return 1;
        
        // op1 == '('
        if(op1.equals("(")) return -1;
        
        // op1 == '+' || '-'
        if(op2.equals("+") || op2.equals("-")) return 1;
        if(op2.equals("*") || op2.equals("/")) return -1;
        
        return 0;
    } 
     
    public int evaluateExpression(String[] expression) {
        // write your code here
        if(expression == null || expression.length < 1) return 0;
        
        Stack<String> ops = new Stack<String>();
        Stack<Integer> nums = new Stack<Integer>();
        
        for(String cur : expression) {
            if(cur.equals("(")) {
                ops.push(cur);
            } else if(cur.equals(")")) {
                // compute until pop a (
                while( !ops.isEmpty() &&
                    !ops.peek().equals("(") ) {
                
                    int num2 = nums.pop();
                    int num1 = nums.pop();
                    String op = ops.pop();
                    int res = compute(num1, num2, op);
                    nums.push(res);                        
                }
                ops.pop();
            } else if( isOperator(cur)) {
                while( !ops.isEmpty() &&
                    priority(ops.peek(), cur) > 0) {
                    int num2 = nums.pop();
                    int num1 = nums.pop();
                    String op = ops.pop();
                    int res = compute(num1, num2, op);
                    nums.push(res);
                }
                ops.push(cur);
            } else { //must be a number
                Integer i = Integer.parseInt(cur);
                nums.push(i);
            }
        }
        
        while(!ops.isEmpty()) {
            int num2 = nums.pop();
            int num1 = nums.pop();
            String op = ops.pop();
            int res = compute(num1, num2, op);
            nums.push(res);
        }
        
        if(nums.size() == 1) return nums.pop();
        else return 0;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ex = { "2","*","6","-","(","23","+","7",")","/","(","1","+","2",")" };
		
//		String str = "5 + ( ( 32 - 11 ) - 1 + 34 )";
//		ex = str.trim().split(" ");
		
		ExpressionEvaluation so = new ExpressionEvaluation();
		int ans = so.evaluateExpression(ex);
		
		System.out.println(ans);
		
	}

}
