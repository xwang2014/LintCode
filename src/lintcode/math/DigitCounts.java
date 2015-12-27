package lintcode.math;

public class DigitCounts {
	
    public int digitCounts(int k, int n) {
        // write your code here
    	int count = 0;
    	
    	String num = "" + n;
    	
    	int base = 1;
    	for(int i = num.length() - 1; i >= 0; i--) {
    		int digit = num.charAt(i) - '0';
    		
    		count += ( n / (base * 10) ) * base ;
    		if(digit < k) {
    			
    		} else if(digit > k) {
    			count += 1 * base;
    		} else { // digit = k
    			count += (n % base + 1); //* base;
    		}
    		
    		base *= 10;
    	}
    	
    	return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitCounts so = new DigitCounts();
		
		int cnt = so.digitCounts(2, 302); 
		System.out.println(cnt);
		
		cnt = so.digitCounts(1, 12);  //(1,12) -> 5
		System.out.println(cnt);
		
		cnt = so.digitCounts(1, 22);  
		System.out.println(cnt);
		
		cnt = so.digitCounts(1, 200);  
		System.out.println(cnt);
	}

}
