package lintcode.math;

public class DivideTwoIntegers {
	// http://blog.csdn.net/linhuanmars/article/details/20024907
	
    public int divide(int dividend, int divisor) {
        // Write your code here
        if(dividend == 0 || divisor == 0) return 0;
        
        boolean positive = true;
        if(dividend > 0 && divisor < 0) positive = false;
        else if(dividend < 0 && divisor > 0) positive = false;
        
        long a = (long) dividend;
        if(a < 0) a = -a;
        
        long b = (long) divisor;
        if(b < 0) b = -b;
        
        int k = 0;
        
        while( (b << 1) < a) {
            b = b << 1;
            k++;
        }
        
        long res = 0;
        while(a >= b && k >= 0) {
            while(a >= b) {
                a = a - b;
                res += (1 << k);
            }
            while(a < b) {
            	b = b >> 1;
            	k--;
            }
        }
        
        if(positive) {
            if(res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else res = (int) res;
        } else {
            if(res > (0L - Integer.MIN_VALUE) ) return Integer.MIN_VALUE;
            else res = (0L - res);
        }
        
        int ans = (int) res;
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideTwoIntegers so = new DivideTwoIntegers();
		
		int ans = so.divide(2147483647, 3);
		
		System.out.println(ans);
		
	}

}
