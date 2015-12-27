package lintcode;

import java.util.ArrayList;

public class ProductofArrayExcludeItsel {
	
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> ans = new ArrayList<Long>();
        if(A == null || A.size() < 1) return ans;
        
        int size = A.size();
        long[] forward = new long[size];
        long[] backward = new long[size];
        
        long product = A.get(0);
        forward[0] = 1L;
        for(int i = 1; i < size; i++) {
            forward[i] = product;
            product *= A.get(i);
        }
        
       
        backward[size - 1] = 1L;
        product = A.get(size - 1);
        for(int i = size - 2; i >= 0; i--) {
            backward[i] = product;
            product *= A.get(i);
        }
        
        for(int i = 0; i < size; i++) {
            ans.add(forward[i] * backward[i]);
        }
        
        return ans;
    }

	public static void main(String[] args) {
		int[] A = {1, 2, 3 };
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : A) list.add(i);
		
		ProductofArrayExcludeItsel so = new ProductofArrayExcludeItsel();
		ArrayList<Long> ans = so.productExcludeItself(list);

		System.out.println(ans);
	}

}
