package lintcode.math;

public class TrailingZeros {
	
    public long trailingZeros(long n) {
        // find the number of 5 in factors 
        int ans = 0;
        
        
        for(long i = 5; i <= n; i += 5) {
            ans += getFive(i);
        }
        
        return ans;
    }
    
    private long getFive(long t) {
        long num = 0;
        while(t > 0) {
        	if(t % 5 == 0) num++;
            t = t / 5;
        }
        return num;
    }

	public static void main(String[] args) {
		TrailingZeros so = new TrailingZeros();
		
		long ans = so.trailingZeros(105);
		
		System.out.println(ans);
	}

}
