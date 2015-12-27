package leetcode;

import java.util.ArrayList;

public class PerfectSquares {
	
    ArrayList<Integer> list = null;
    
    public int numSquares(int n) {
        if(n <= 3) return n;
        list = new ArrayList<Integer>();
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        
        for(int i = 1; i <= n; i++) {
            int idx = getIdx(i);
            dp[i] = i;
            for(int j = 0; j <= idx; j++) {
            	if(i >= list.get(j)) {
            		dp[i] = Math.min(dp[i], dp[i - list.get(j)] + 1);
            	}
            }
        }
        
        return dp[n];
    }
    
    private int getIdx(int n) {
        int root = n;
        
        int size = list.size();
        while(size * size < root) {
            size++;
            list.add(size * size);
        }
        
        int start = 0, end = list.size() - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midVal = list.get(mid);
            
            if(midVal < root) {
                start = mid;
            } else if(midVal > root) {
                end = mid;
            } else {
                end = mid;
            }
        }
        
        if(list.get(start) >= root) return start;
        else return end;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectSquares so = new PerfectSquares();
		
		int ans = so.numSquares(13);
		
		System.out.println(ans);
	}

}
