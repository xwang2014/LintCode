package lintcode.dp;

public class CoinsinaLineIII {
	
	/*
    // https://codesolutiony.wordpress.com/2015/05/24/lintcode-coins-in-a-line-iii/
    public boolean firstWillWin(int[] values) {
        if(values == null || values.length <= 2) return true;
        //f[i][j] means the max value first player can collect from coins [i, j]
        
        int len = values.length;
        
        int[][] f = new int[len][len];
        for(int i = 0; i < len; i++) {
            f[i][i] = values[i];
        }
        
        int[][] sum = new int[len][len];
        for(int i = 0; i < len; i++) {
            int cur = 0;
            for(int j = i; j < len; j++) {
                cur += values[j];
                sum[i][j] = cur;
            }
        }
        
        // f[i][j] = v[i] + sum[i + 1, j] - f[i+1][j]  OR
        //            v[j] + sum[i, j-1] - f[i][j - 1]
        
        for(int i = len - 1; i >= 0; i--) {
            for(int j = i + 1; j <= len - 1; j++) {
                
                int head = 0;
                if(i + 1 <= j) head = sum[i][j] - f[i + 1][j];
                
                
                int tail = 0;
                if(i <= j - 1) tail = sum[i][j] - f[i][j - 1];
                
                f[i][j] = Math.max(head, tail);
            }
        }
        
        return f[0][len - 1] > sum[0][len - 1] - f[0][len - 1];
    }
    */
	
    int[][] f = null;
    boolean[][] visited = null;
    public boolean firstWillWin(int[] values) {
        //f[x][y]  means there are coins[x, y] to fetch
        //f[i][j] =  A[i] + math.min(f[i + 2][j], f[i + 1][j - 1])
        //           A[j] + math.min(f[i][j - 2], f[i + 1][j - 1])
        // init f[x][x] = A[x]                   
        //      f[x][x + 1] = max(A[x], A[x + 1])       
          
        if(values == null || values.length < 1) return true;
        
        int len = values.length;
        f = new int[len][len];
        visited = new boolean[len][len];
        
        // init
        for(int i = 0; i < values.length; i++) {
            f[i][i] = values[i];
            
            if(i < values.length - 1) {
                f[i][i + 1] = Math.max(values[i], values[i + 1]);
            }
        }
        
        
        // transition
        int sum = 0;
        for(int i : values) sum += i;
        
        process(0, len-1, values);
        
        return f[0][len-1] > sum - f[0][len-1];
    }
    
    private int process(int x, int y, int[] values) {
        if(visited[x][y]) return f[x][y];
        
        visited[x][y] = true;
        if(x == y) return values[x];
        else if(x + 1 == y) return f[x][y];
        else {
            int left = values[x] + Math.min(process(x+2, y, values), process(x+1, y-1, values) );
            int right = values[y] + Math.min(process(x, y-2, values), process(x+1, y-1, values));
            f[x][y] = Math.max(left ,right);
            return f[x][y];
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinsinaLineIII so = new CoinsinaLineIII();
		
		int[] values = { 1,1,1,1,1,1,1};
		boolean f = so.firstWillWin(values);
		
		System.out.println(f);
	}

}
