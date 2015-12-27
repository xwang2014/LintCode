package lintcode.stack;

import java.util.Stack;

import lintcode.ExpressionTreeNode;

public class ExpressionTreeBuild {

	public ExpressionTreeNode build(String[] expression) {
		// write your code here
		if (expression == null || expression.length < 1)
			return null;

		Stack<String> ops = new Stack<String>();
		Stack<ExpressionTreeNode> nums = new Stack<ExpressionTreeNode>();

		for (String cur : expression) {
			if (cur.equals("(")) {
				ops.push(cur);
			} else if (cur.equals("+") || cur.equals("-") || cur.equals("*")
					|| cur.equals("/")) {

				while (!ops.isEmpty() && prior(ops.peek(), cur)) {
					ExpressionTreeNode num2 = nums.pop();
					ExpressionTreeNode num1 = nums.pop();
					String op = ops.pop();
					ExpressionTreeNode res = compute(num1, num2, op);
					nums.push(res);
				}

				ops.push(cur);
			} else if (cur.equals(")")) {
				while (!ops.peek().equals("(")) {
					ExpressionTreeNode num2 = nums.pop();
					ExpressionTreeNode num1 = nums.pop();
					String op = ops.pop();
					ExpressionTreeNode res = compute(num1, num2, op);
					nums.push(res);
				}
				ops.pop();
			} else { // num
				int v = Integer.parseInt(cur);
				ExpressionTreeNode node = new ExpressionTreeNode(v + "");
				nums.push(node);
			}
		}

		
		while(!ops.isEmpty()) {
			ExpressionTreeNode num2 = nums.pop();
			ExpressionTreeNode num1 = nums.pop();
			String op = ops.pop();
			ExpressionTreeNode res = compute(num1, num2, op);
			nums.push(res);
		}
		
		if(nums.size() == 1)
			return nums.pop();
		else {
			return null;
		}
	}

	private boolean prior(String op1, String op2) {
		if (op1.equals("*") || op1.equals("/"))
			return true;
		if (op1.equals("("))
			return false;

		// op1 == + -
		if (op2.equals("+") || op2.equals("-"))
			return true;
		else
			return false;
	}

	private ExpressionTreeNode compute(ExpressionTreeNode num1,
			ExpressionTreeNode num2, String op) {
		ExpressionTreeNode cur = new ExpressionTreeNode(op);
		cur.left = num1;
		cur.right = num2;

		return cur;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
