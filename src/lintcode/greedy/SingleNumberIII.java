package lintcode.greedy;

import java.util.ArrayList;
import java.util.List;

public class SingleNumberIII {
	
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        
        int[] bits = new int[32];
        for(int i = 0; i < A.length; i++) {
            int curNum = A[i];
            for(int j = 0; j < 32; j++) {
                int curBit = (1 << j) & curNum;
                if(curBit != 0) {
                    bits[j]++;
                }
            }
        }
        
        int diffIndex = 0;
        for(diffIndex = 0; diffIndex < 32; diffIndex++) {
            if(bits[diffIndex] % 2 != 0) {
                 break;
            }
        }
        
        // group nums into two groups
        int zero = 0, one = 0;
        for(int i = 0; i < A.length; i++) {
            
            if( (A[i] & (1 << diffIndex)) == 0 ) {
                zero = zero ^ A[i];
            } else {
                one = one ^ A[i];
            }
        }
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(one);
        list.add(zero);
        
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumberIII so = new SingleNumberIII();
		
		int[] A = { -1 ,2147483647 };
		
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.toBinaryString(2147483647));
		List<Integer> l = so.singleNumberIII(A);
		System.out.println(l);
	}

}
