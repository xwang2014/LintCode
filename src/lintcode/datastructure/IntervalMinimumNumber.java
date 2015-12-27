package lintcode.datastructure;

import java.util.ArrayList;

import lintcode.Interval;

public class IntervalMinimumNumber {
	
    class Node {
        int start;
        int end;
        long min = Integer.MAX_VALUE;
        
        Node left, right;
        public Node(int s, int e) {
            start = s;
            end = e;
        }
    }     
    
    
   public ArrayList<Integer> intervalMinNumber(int[] A, 
                                               ArrayList<Interval> queries) {
       // write your code here
       ArrayList<Integer> ans = new ArrayList<Integer>();
       if(A == null || A.length == 0 || 
           queries == null || queries.size() == 0) {
               return ans;
       }
       
       Node root = build(A, 0, A.length - 1);
       
       for(Interval in : queries) {
           if(in.start < 0) in.start = 0;
           if(in.end > A.length - 1) in.end = A.length - 1;
           int res = (int)query(in, root);
           ans.add(res);
       }
       
       return ans;        
       
   }
   
   public long query(Interval in, Node root) {
       if(in.start > in.end) return Integer.MAX_VALUE;
       
       if(in.start == root.start && in.end == root.end) {
           return root.min;
       }
       
       int mid = root.start + (root.end - root.start) / 2;
       
       long leftMin = query(new Interval(in.start, Math.min(mid, in.end)), root.left);
       long rightMin = query(new Interval(Math.max(mid + 1, in.start), in.end), root.right);
      
       return Math.min(leftMin, rightMin);
   }    
   
   
   public Node build(int[] A, int start, int end) {
       Node root = new Node(start, end);
       
       if(start == end) {
           root.min = A[start];
           return root;
       }
       
       int mid = start + (end - start) / 2;
       root.left = build(A, start, mid);
       root.right = build(A, mid + 1, end);
       
       root.min = Integer.MAX_VALUE;
       if(root.left != null) root.min = Math.min(root.min, root.left.min);
       if(root.right != null) root.min = Math.min(root.min, root.right.min);
       
       return root;
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,7,8,5};
		ArrayList<Interval> ins = new ArrayList<Interval>();
		ins.add(new Interval(0, 4));
		
		IntervalMinimumNumber so = new IntervalMinimumNumber();
		
		ArrayList<Integer> ans = so.intervalMinNumber(A, ins);
		
		for(Integer l : ans) {
			System.out.println(l);
		}
	}

}
