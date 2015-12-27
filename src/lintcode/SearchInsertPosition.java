package lintcode;

public class SearchInsertPosition {
	
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A == null) return -1;
        if(A.length == 0) return 0;
        
        int start = 0, end = A.length - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midVal = A[mid];
            
            if(midVal == target) {
                end = mid;
            } else if(midVal < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if(target <= A[start]) return start;
        else if(target <= A[end]) return end;
        else return end + 1;
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
