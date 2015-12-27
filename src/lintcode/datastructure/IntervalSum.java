package lintcode.datastructure;

import java.util.ArrayList;

import lintcode.Interval;

public class IntervalSum {
	
    class Node {
        int start;
        int end;
        long sum = 0;
        
        Node left, right;
        public Node(int s, int e) {
            start = s;
            end = e;
        }
    }
   public ArrayList<Long> intervalSum(int[] A, 
                                      ArrayList<Interval> queries) {
       // write your code here
       ArrayList<Long> ans = new ArrayList<Long>();
       if(A == null || A.length == 0 || 
           queries == null || queries.size() == 0) {
               return ans;
       }
       
       Node root = build(A, 0, A.length - 1);
       
       for(Interval in : queries) {
           if(in.start < 0) in.start = 0;
           if(in.end > A.length - 1) in.end = A.length - 1;
           long res = query(in, root);
           ans.add(res);
       }
       
       return ans;
   }
   
   public long query(Interval in, Node root) {
       if(in.start > in.end) return 0;
       if(in.start == root.start && in.end == root.end) {
           return root.sum;
       }
       
       int mid = root.start + (root.end - root.start) / 2;
       
       long leftSum = query(new Interval(in.start, Math.min(mid, in.end)), root.left);
       long rightSum = query(new Interval(Math.max(mid + 1, in.start), in.end), root.right);
       
       return leftSum + rightSum;
   }
   
   public Node build(int[] A, int start, int end) {
       Node root = new Node(start, end);
       
       if(start == end) {
           root.sum = A[start];
           return root;
       }
       
       int mid = start + (end - start) / 2;
       root.left = build(A, start, mid);
       root.right = build(A, mid + 1, end);
       if(root.left != null) root.sum += root.left.sum;
       if(root.right != null) root.sum += root.right.sum;
       
       return root;
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,1,4,5};
		ArrayList<Interval> ins = new ArrayList<Interval>();
		ins.add(new Interval(0, 0));
		
		IntervalSum so = new IntervalSum();
		
		ArrayList<Long> ans = so.intervalSum(A, ins);
		
		for(Long l : ans) {
			System.out.println(l);
		}
	}

}
