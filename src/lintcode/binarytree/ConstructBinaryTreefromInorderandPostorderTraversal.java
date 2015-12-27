package lintcode.binarytree;

import lintcode.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        int len = inorder.length;
        
        return getNode(inorder, 0, len - 1, postorder, 0, len - 1);
    }
    
    private TreeNode getNode(int[] inorder, int i1, int i2,
                            int[] postorder, int p1, int p2) {
    
        if(p1 > p2) return null;
        
        int r = postorder[p2];
        int idx = -1;
        for(idx = i1; idx <= i2; idx++) {
            if(inorder[idx] == r) break;
        }
        
        TreeNode root = new TreeNode(r);
        
        root.left = getNode(inorder, i1, idx - 1, 
            postorder, p1, p1 + (idx - i1) - 1 );
        
        root.right = getNode(inorder, idx + 1, i2, 
            postorder, p1 + (idx - i1), p2 - 1 );
        
        return root;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
