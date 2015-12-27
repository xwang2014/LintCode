package lintcode;

public class FindMinimumInRotatedSortedArray {
	// http://www.lintcode.com/en/problem/find-minimum-in-rotated-sorted-array/#
	
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length < 1) return -1;
        
        int start = 0, end = num.length -1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midVal = num[mid];
            
            if(midVal < num[end]) { // left
                end = mid;
            } else {
                start = mid;
            }
        }
        
        return (num[start] < num[end]) ? num[start] : num[end];
    }

    /*
    public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length < 1) return -1;
        
        int start = 0, end = num.length -1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midVal = num[mid];
            
            if(midVal < num[mid - 1] && midVal < num[mid + 1]) {
                return midVal;
            }
            
            int startVal = num[start];
            int endVal = num[end];
            
            if(startVal < midVal && midVal > endVal) {
                start = mid;
            } else if(startVal > midVal && midVal < endVal) {
                end = mid;
            } else {
                end = mid;
            }
        }
        
        if(num[start] < num[end]) return num[start];
        else return num[end];
    }
    */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
