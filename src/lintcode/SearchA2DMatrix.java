package lintcode;

public class SearchA2DMatrix {
	// http://www.lintcode.com/en/problem/search-a-2d-matrix/
	
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int start = 0, end = matrix.length - 1;
        // Find the rows
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midVal = matrix[mid][0];
            
            if(midVal == target) {
                end = mid;
            } else if(midVal < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        int row = -1;
        if(target < matrix[end][0]) row = start;
        else row = end;
        
        start = 0;
        end = matrix[row].length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midVal = matrix[row][mid];
            
            if(midVal == target) {
                end = mid;
            } else if(midVal < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if(matrix[row][start] == target || 
            matrix[row][end] == target) {
                return true;
            }
        else {
            return false;
        }
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
