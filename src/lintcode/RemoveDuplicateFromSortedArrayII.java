package lintcode;

public class RemoveDuplicateFromSortedArrayII {
	
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null) return 0;
        if(nums.length <= 2) return nums.length;
        
      
        int duplicate = 0;
        int index = 0;
        int i = 0;
        while(i < nums.length) {
            int value = nums[i];
            int count = 1;
            while(i > 0 && i < nums.length
                    && nums[i] == nums[i - 1] ) {
                duplicate++;
                count++;
                i++;
            }
            
            if(count == 1) {
                nums[index++] = value;
                i++;
            } else if(count >= 2) {
                nums[index++] = value;
                nums[index++] = value;
            } 
            // else { // count > 2
                
            // }
        }
        
        return index - 1 ;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicateFromSortedArrayII so = new RemoveDuplicateFromSortedArrayII();
		
		int[] nums = {1, 1, 1};
		
		int len = so.removeDuplicates(nums);
		
		for(int i = 0; i < len; i++) {
			System.out.print(nums[i] + "  ");
		}
	}

}
