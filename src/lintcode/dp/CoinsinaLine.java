package lintcode.dp;

public class CoinsinaLine {
	
    public boolean firstWillWin1(int n) {
        // write your code here
        if(n == 0) return false;
        if(n == 1) return true;
        if(n == 2) return true;
        if(n == 3) return false;
        if(n == 4) return true;
        
        boolean one = true, two = true, three = false, four = true;
        // pick one
        int index = 4;
        boolean flag = true;
        while(index < n) {
            boolean pickOne = two && three;
            boolean pickTwo = one && two;
            flag = pickOne || pickTwo;
            
            System.out.print(flag + " ");
            index++;
            one = two;
            two = three;
            three = four;
            four = flag;
        }
       
       
        return flag;
    }
	
    public boolean firstWillWin(int n) {
        // write your code here
        boolean one = true, two = true, three = false, four = true;
        if(n == 1) return one;
        if(n == 2) return two;
        if(n == 3) return three;
        if(n == 4) return four;
        
        boolean cur = false;
        
        for(int i = 5; i <= n; i++) {
            // choose one
            boolean curOne = two && three;
            
            // choose two
            boolean curTwo = one && two;
            
            cur = curOne || curTwo;
        
            one = two;
            two = three;
            three = four;
            four = cur;
        }
        
        return cur;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CoinsinaLine so = new CoinsinaLine();
		
		so.firstWillWin1(15);
		System.out.println();
		so.firstWillWin(15);
	}

}
