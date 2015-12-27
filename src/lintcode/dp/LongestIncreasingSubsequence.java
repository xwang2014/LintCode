package lintcode.dp;

public class LongestIncreasingSubsequence {
	
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;
        
        // state, f[i] means the long subseq ending with nums[i]
        int[] f = new int[nums.length];
        
        // init
        for(int i = 0; i < f.length; i++)
        	f[i] = 1;
        
        // transition func
        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] <= nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        
        int len = 0;
        for(int i : f) {
        	len = Math.max(len, i);
        }
        return len;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingSubsequence so = new LongestIncreasingSubsequence();
		
		int[] nums = { 9,3,6,2,7 };
		int l = so.longestIncreasingSubsequence(nums);
		System.out.println(l);
	}

}
