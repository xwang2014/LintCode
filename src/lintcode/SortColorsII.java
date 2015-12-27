package lintcode;

public class SortColorsII {
	
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors == null || colors.length < 1) return;
        
        int start = 0;
        for(int i = 2; i <= k; i++) {
            start = pivot(colors, start, i);
        }
    }
    
    private int pivot(int[] colors, int start, int pivot) {
        int left = start, right = colors.length - 1;
        
        while(left <= right) {
            int cur = colors[left];
            
            if(cur < pivot) {
                left++;
            } else {
                colors[left] = colors[right];
                colors[right] = cur;
                
                right--;
            }
        }
        
        return left;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortColorsII so = new SortColorsII();
		
		int[] A = {2,2,3,1,1,1,2,3,2,2};
		so.sortColors2(A, 3);
		
		for(int t : A) {
			System.out.print(t + "  ");
		}
	}

}
