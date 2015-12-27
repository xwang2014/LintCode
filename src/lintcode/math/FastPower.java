package lintcode.math;

public class FastPower {
	
    /*
     * http://www.cnblogs.com/yuzhangcmu/p/4174781.html    
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // Rule: (a * b) % p = (a % p * b % p) % p
        
        long res = getAns((long)a, (long)b, (long) n);
        return (int) res;
    }
    
    private long getAns(long a, long b, long n) {
        // a ^ n % b = (a ^ n/2 % b * a ^ n/2 % b) % b;
        if(n == 0) {
            return 1 % b;
        }
        if(n == 1) {
            return a % b;
        }
        
        long half = getAns(a, b, n / 2);
        
        half *= half;
        half %= b;
        
        if(n % 2 == 0) { // ( half * half) % b
            return half ;
        } else { // (half * half * a) % b
            return (half * ( a )) % b;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
