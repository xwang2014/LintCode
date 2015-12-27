package lintcode.twopointers;

public class MinimumSizeSubarraySum {

    public int minimumSize(int[] nums, int s) {
        // write your code here
        if(nums == null || nums.length < 1) return -1;
        
        int start = 0, end = 0, sum = nums[0];
        int minLen = -1;
        while(end <= nums.length - 1) {
            
            if(sum < s) {
                end++;
                if(end > nums.length - 1) break;
                
                sum += nums[end];
            } else { // sum >= s
                if(minLen == -1 || minLen > end - start + 1) {
                    minLen = end - start + 1;
                }
                sum -= nums[start];
                start++;
            }
        }
        
        return minLen;
    }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumSizeSubarraySum so = new MinimumSizeSubarraySum();
		
		int[] A = { 2,3,1,2,4,3 };
		
		int len = so.minimumSize(A, 7);
		System.out.println(len);
	}

}
