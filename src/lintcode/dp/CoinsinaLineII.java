package lintcode.dp;

public class CoinsinaLineII {
	
	
    // https://github.com/kamyu104/LintCode/blob/master/C++/coins-in-a-line-ii.cpp
    
    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values == null || values.length <= 2) return true;
        
        int sum = 0;
        for(int v : values) sum += v;
        
        int len = values.length;
        int[] f = new int[len];
        f[len - 1] = values[len - 1];
        
        for(int i = len - 2; i >= 0; i--) {
            
            int a = i < len - 1 ? values[i + 1] : 0 ;
            int b = i < len - 2 ? f[i + 2] : 0;
            int c = i < len - 3 ? f[i + 3] : 0;
            int d = i < len - 4 ? f[i + 4] : 0;
            
            // pick one
            int one = values[i] + Math.min(b, c);
            // pick two
            int two = values[i] + a + Math.min(c, d);
            f[i] = Math.max(one, two);
        }
        for(int vf : f ) System.out.print(vf + " ");
        return f[0] > sum - f[0]  ;
    }

    public boolean firstWillWin25(int[] values) {
        if(values == null || values.length < 3) return true;
        
        int[] f = new int[values.length];
        int total = 0;
        for(int n : values) total += n;
        
        int len = values.length;
        f[len - 1] = values[len - 1];
        f[len - 2] = values[len - 1] + values[len - 2];
        
        for(int i = len - 3; i >= 0; i--) {
        	
        	int a = (i < len - 1) ? f[i + 1] : 0;
        	int b = (i < len - 2) ? f[i + 2] : 0;
        	int c = (i < len - 3) ? f[i + 3] : 0;
        	int d = (i < len - 4) ? f[i + 4] : 0;
        	
        	int chooseOne = Math.min(b, c) + values[i];
        	int chooseTwo = Math.min(c, d) + values[i] + values[i + 1];
        	
        	f[i] = Math.max(chooseOne, chooseTwo);
        }
        
        for(int vf : f ) System.out.print(vf + " ");
        
        return f[0] > total - f[0];
    }
    
    
    public boolean firstWillWin2(int[] values) {
        // write your code here
        if(values == null || values.length < 3) return true;
        
        int[] f = new int[values.length];
        int total = 0;
        for(int n : values) total += n;
        
        f[0] = values[0];
        f[1] = f[0] + values[1];
        
        
        f[2] = values[0] + values[1];
        if(values.length == 3) return f[2] > total / 2;
        
        f[3] = Math.max(values[0] + values[1], values[0] + values[3]);

        for(int i = 4; i < values.length; i++) {
            //choose one
            int curOne = Math.min(f[i - 2] + values[i], 
                f[i - 3] + values[i]);
            
            // choose two
            int curTwo = Math.min( f[i - 3] + values[i] + values[i - 1],
                          f[i - 4] + values[i] + values[i - 1]);
                            
            f[i] = Math.max(curOne, curTwo);
            
        }
        for(int vf : f ) System.out.print(vf + " ");
        return f[f.length - 1] > total - f[f.length - 1];
    }
    
    
    
    public boolean firstWillWin3(int[] values) {
        // write your code here
        int []dp = new int[values.length + 1];
        boolean []flag =new boolean[values.length + 1];
        int sum = 0;
        for(int now : values) 
            sum += now;
        
        boolean vflag = ( sum < 2*MemorySearch( values.length, dp, flag, values) );
        return vflag;
    }
    int MemorySearch(int n, int []dp, boolean []flag, int []values) { 
        if(flag[n] == true)
            return dp[n];
        flag[n] = true;
        if(n == 0)  {
            dp[n] = 0;  
        } else if(n == 1) {
            dp[n] = values[values.length-1];
        } else if(n == 2) {
            dp[n] = values[values.length-1] + values[values.length-2]; 
        } else if(n == 3){
            dp[n] = values[values.length-2] + values[values.length-3]; 
        } else {
            dp[n] = Math.max(
                Math.min(MemorySearch(n-2, dp, flag,values) , MemorySearch(n-3, dp, flag, values)) + values[values.length-n],
                Math.min(MemorySearch(n-3, dp, flag, values), MemorySearch(n-4, dp, flag, values)) + values[values.length-n] + values[values.length - n + 1]
                );
        }
    
        return dp[n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] v = {100,200,400,300,400,800,500,600,1200};
		
		CoinsinaLineII so = new CoinsinaLineII();
		boolean f = so.firstWillWin25(v);
		System.out.println();
		f = so.firstWillWin(v);
		System.out.println();
		f = so.firstWillWin2(v);
		System.out.println();
		
		System.out.println(f);
	}

}
