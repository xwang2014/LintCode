package lintcode.binarysearch;

public class WoodCut {
	
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L == null || L.length == 0) return 0;
        
        int shortLen = L[0];
        for(int i = 1; i < L.length; i++) {
            if(L[i] < shortLen) {
                shortLen = L[i];
            }
        }
        
        int start = 1, end = shortLen;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            int num = cut(L, mid);
            
            if(num < k) {
                end = mid;
            } else { // num >= k
                start = mid;
            }
        }
        
        while(cut(L, end - 1) == k) {
            end = end - 1;
        }
        
        return start;
    }
    
    private int cut(int[] L, int len) {
        int num = 0;
        for(int i = 0; i < L.length; i++) {
            num += L[i] / len;
        }
        return num;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WoodCut so = new WoodCut();
		
		int[] L = {2147483644,2147483645,2147483646,2147483647} ;
		System.out.println(so.woodCut(L, 4));
	}

}
