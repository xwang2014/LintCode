package lintcode.binarysearch;

public class Sqrt {
	
    public int sqrt(int x) {
        // write your code here
        if(x <= 0) return 0;
        if(x <= 3) return 1;
        
        // x >= 4
        return process(x, 2, x);
    }
    
    private int process(int x, int start, int end) {
        if(start >= end) return start;
        
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            long square = mid * (long)mid;
            
            if(square == x) {
                return mid;
            } else if(square < x) {
                start = mid;
            } else { // square > x
                end = mid;
            }
        }
        
        if(start * start <= x && end * end > x) {
            return start;
        } else {
            return end;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sqrt so = new Sqrt();
		
		System.out.println(so.sqrt(2147483647));
	}

}
