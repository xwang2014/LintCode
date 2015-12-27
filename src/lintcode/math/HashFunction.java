package lintcode.math;

public class HashFunction {
	
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long sum = 0, k = key.length - 1;
        long base = 1;
        for(int i = key.length - 1; i >= 0; i--) {
        	long temp = (long) key[i];
        	sum += temp * base;
        	
        	base = (base * 33) % HASH_SIZE;
        }
        
        return (int)(sum % HASH_SIZE);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashFunction so = new HashFunction();
		char[] key = { 'a', 'b', 'c', 'd' };
		
		String str = "abcdefghijklmnopqrstuvwxyz";
		int n = so.hashCode(str.toCharArray(), 2607);
		
		System.out.println(n);
	}

}
