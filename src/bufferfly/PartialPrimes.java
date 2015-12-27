package bufferfly;

public class PartialPrimes {
	
	// check every substring is prime or not
	// store the largest prime
	// cut the cases that current substring is less than largest prime found
	
	int prime = 1;
	public int largestPartialPrime(int n) {
		if(n <= 1) return -1;
		
		String num = "" + n;
		int len = num.length();
		prime = 1;
		
		for(int i = 0; i < len; i++) {
			for(int j = i + 1; j <= len; j++) {
				String sub = num.substring(i, j);
				int val = Integer.parseInt(sub);
				
				if(val <= prime) continue;
				if(!isPrime(val)) continue;
				
				prime = val;
			}
		}
		
		return prime;
	}
	
	
	
	private boolean isPrime(int n) {
		if(n <= 1) return false;
		if(n == 2 || n == 3) return true;
		
		int root = (int)Math.sqrt(n);
		for(int i = 2; i <= root; i++) {
			if(n % i == 0) return false;
		}
		
		return true;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
