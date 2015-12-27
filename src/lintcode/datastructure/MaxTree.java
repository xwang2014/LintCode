package lintcode.datastructure;

import java.util.Stack;

import lintcode.TreeNode;


public class MaxTree {
	
    // http://www.cnblogs.com/lishiblog/p/4187936.html 
    
    
    public TreeNode maxTree(int[] A) {
        // write your code here
        if(A == null || A.length == 0) return null;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        for(int i = 0; i < A.length; i++) {
            TreeNode cur = new TreeNode(A[i]);
            
            if(stack.isEmpty()) {
                stack.push(cur);
                continue;
            }
            
            if(cur.val < stack.peek().val) {
                stack.push(cur);
                continue;
            } else {
                TreeNode n1 = stack.pop();
                while(!stack.isEmpty() && stack.peek().val < cur.val) {
                    TreeNode n2 = stack.pop();
                    n2.right = n1;
                    n1 = n2;
                }
                
                cur.left = n1;
                stack.push(cur);
            }
        }
        
        TreeNode root = null;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            node.right = root;
            root = node;
            
        }
        
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
