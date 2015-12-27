package lintcode;

public class FindPeakElement {
	// http://www.lintcode.com/en/problem/find-peak-element/#
	
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if(A == null || A.length < 3) return -1;
        
        int start = 0, end = A.length - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if(A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) return mid;
            
            if(A[mid - 1] > A[mid]) {
                end = mid;
            } 
            else if(A[mid] < A[mid + 1]) {
                start = mid;
            }
        }
        
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
