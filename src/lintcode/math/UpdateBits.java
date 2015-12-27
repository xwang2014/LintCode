package lintcode.math;

public class UpdateBits {
	
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
    	
    	int m1 = (1 << (j + 1)) - 1;
    	int m2 = (1 << (i)) - 1;
        if(j >= 31) {
        	m1 = 0xFFFFFFFF;
        }
//        if(i >= 31) {
//        	m2 = 0xFFFFFFF;
//        }
        int mask = ~(m1 ^ m2);
        
        int cover = n & mask;
        
        int m_left = m << i;
        int res = m_left | cover;
        
        System.out.println(Integer.toBinaryString(m1));
        System.out.println(Integer.toBinaryString(m2));
        System.out.println(Integer.toBinaryString(mask));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(cover));
        System.out.println(Integer.toBinaryString(m_left));
        System.out.println(Integer.toBinaryString(res));
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpdateBits so = new UpdateBits();
		
		//int ans = so.updateBits(-521,0,31,31);
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(1 << 31);
		System.out.println(Integer.MIN_VALUE);
	}

}
