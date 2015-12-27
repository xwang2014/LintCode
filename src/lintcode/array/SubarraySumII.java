package lintcode.array;

public class SubarraySumII {
	
    class Node {
        int start;
        int end;
        int count;
        
        Node left, right;
        public Node(int s, int e) {
            start = s;
            end = e;
        }
    } 
    
    private Node build(int min, int max) {
        if(min > max) return null;
        if(min == max) {
            Node cur = new Node(min, max);
            return cur;
        }
        
        Node cur = new Node(min, max);
        
        int mid = min + (max - min) / 2;
        Node left = build(min, mid);
        Node right = build(mid + 1, max);
        
        cur.left = left;
        cur.right = right;

        return cur;
    }
    
    private int query(Node node, int start, int end) {
        if(node == null || start > node.end 
            || end < node.start) 
            return 0;
        if(node.start == start && node.end == end)  {
            return node.count;
        }
        
        int mid = (node.start + node.end) / 2;
        
        if(end <= mid) {
            return query(node.left, Math.max(start, node.start), end);
        } else if(start > mid) {
            return query(node.right, start, Math.min(end, node.end));
        } else { // start <= mid < end
            return query(node.left, Math.max(start, node.start), mid) +
                query(node.right, mid + 1, Math.min(end, node.end));
        }
    }
    
    private void modify(Node node, int index, int val) {
        if(node == null) return;
        if(node.start > index || node.end < index) return;
        if(node.start == index && node.end == index) {
            node.count += val;
            return;
        }
        
        int mid = (node.start + node.end) / 2;
        if(index <= mid) {
            modify(node.left, index, val);
        } else { // index > mid
            modify(node.right, index, val);
        }
        
        node.count = node.left.count + node.right.count;
    }
    
    Node root = null; 
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        if(A == null || A.length < 1) return 0;
        
        int[] sum = new int[A.length];
        int s = 0;
        
        for(int i = 0; i < A.length; i++) {
            s += A[i];
            sum[i] = s;
        }
        
        // Find the value range. max and min 
        int max = sum[0], min = 0;
        for(int m : sum) {
            max = Math.max(max, m);
            min = Math.min(min, m);
        }
        
        // Build a segment tree based on value
        this.root = build(min, max);
        
        // 
        int res = 0;
        
        modify(root, 0, 1);
        
        for(int i = 0; i < sum.length; i++) {
            // start <= sum[i] - sum[j] <= end
            int cnt = query(root, sum[i] - end, sum[i] - start );
            res += cnt;
            
            modify(root, sum[i], 1);
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubarraySumII so = new SubarraySumII();
		int[] arr = {1,1,1,1,1,1,1,1,1,1 };
		
		int ans = so.subarraySumII(arr, 1, 10);
		System.out.println(ans);
	}

}
