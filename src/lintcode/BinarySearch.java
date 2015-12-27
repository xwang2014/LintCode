package lintcode;

public class BinarySearch {
	// http://www.lintcode.com/en/problem/binary-search/#
	
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) return -1;
        
        int head = 0, tail = nums.length - 1;
        int idx = -1;
        while (head <= tail) {
            int mid = (head + tail) / 2;
            int cur = nums[mid];
            
            if (cur == target) {
                idx = mid;
                break;
            } else if (cur < target) {
                head = mid + 1;
            } else {
                tail = mid - 1;
            }
        }
        
        while (idx > 0 && nums[idx - 1] == nums[idx]) {
            idx = idx - 1;
        }
        
        return idx;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
