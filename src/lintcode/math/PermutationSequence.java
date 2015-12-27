package lintcode.math;

public class PermutationSequence {
	
    public String getPermutation(int n, int k) {
    	k = k - 1;
        int[] fact = fact(n);
        
        String ans = "";
        boolean[] flag = new boolean[n + 1];
        for(int i = n - 1; i >= 0; i--) {
            int cur = k / fact[i];
            ans += getNum(flag, cur);
            
            k = k % fact[i];
        }
        
        return ans;
    }
    
    private String getNum(boolean[] flag, int cur) {
        // flag starts from 1
    	int index = 0;
    	for(int i = 1; i < flag.length; i++) {
    		if(flag[i]) continue;
    		if(index == cur) {
    			flag[i] = true;
    			return "" + i;
    		} else {
    			index++;
    		}
    	}
    	return "!!!";
    }
    
    private int[] fact(int n) {
        if(n < 1) return (new int[1]);
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i <= n; i++) {
            f[i] = f[i - 1] * i;
        }
        
        return f;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence so = new PermutationSequence();
		
		String s = so.getPermutation(4, 1);
		
		System.out.println(s);
	}

}
