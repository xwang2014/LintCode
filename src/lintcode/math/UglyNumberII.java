package lintcode.math;

public class UglyNumberII {
	
    // http://www.algoqueue.com/algoqueue/default/view/9175040/find-nth-ugly-number-
    
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n + 1];
        ugly[1] = 1;
        
        int idx2 = 1;
        int idx3 = 1;
        int idx5 = 1;

        for(int i = 2; i <= n; i++) {
            int two = ugly[idx2] * 2;
            int three = ugly[idx3] * 3;
            int five = ugly[idx5] * 5;
            
            if(two <= three && two <= five) {
                ugly[i] = two;
                idx2++;
            } else if(three <= two && three <= five) {
                ugly[i] = three;
                idx3++;
            } else if(five <= two && five <= three) {
                ugly[i] = five;
                idx5++;
            } else {
            	System.out.println("Error");
            }
        }
        
        for(int i : ugly) {
        	System.out.print(i + " ");
        }
        
        return ugly[n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UglyNumberII so = new UglyNumberII();
		
		so.nthUglyNumber(13);
	}

}
