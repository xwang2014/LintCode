package lintcode;

public class SearchInRotatedSortedArray {
	
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        
        if(A == null || A.length < 1) return -1;
        
        int start = 0, end = A.length - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midVal = A[mid];
            
            if(midVal == target) return mid;
            
            if(A[start] < midVal) {
                if(A[start] <= target && target < midVal) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if(midVal < target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if(A[start] == target) return start;
        if(A[end] == target) return end;
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
