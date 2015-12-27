package lintcode.sort;

public class Median {
	
//    public int median(int[] nums) {
//        // write your code here
//        if(nums == null || nums.length < 1) return 0;
//        
//        int len = nums.length;
//        if( len % 2 == 0) {
//            return findKth(nums, len / 2 - 1, 0, len - 1);
//        } else {
//            return findKth(nums, len / 2, 0, len - 1);
//        }
//    }
//    
//    private int findKth(int[] nums, int k, int start, int end) {
//        int pivotIdx = (int)(Math.random() * (end + 1 - start)) + start;
//        swap(nums, pivotIdx, end);
//        
//        int l = start, r = end;
//        while(l < r) {
//        	while(nums[l] < nums[end] && l < r) l++;
//        	while(nums[r] >= nums[end] && l < r) r--;
//        	
//        	if(l < r) {
//        		swap(nums, l, r);
//        		l++;
//        		r--;
//        	}
//        }
//        
//        swap(nums, l, end);
//        if(l == k) return nums[l];
//        else if(l < k) {
//        	return findKth(nums, k -l, l + 1, end);
//        } else {
//        	return findKth(nums, k, start, l - 1);
//        }
//        
//    }
//	
//    private void swap(int[] nums, int l, int r) {
//    	int temp = nums[l];
//    	nums[l] = nums[r];
//    	nums[r] = temp;
//    }
    public int median(int[] nums) {
        // write your code here
        if(nums == null || nums.length < 1) return 0;
        
        int len = nums.length;
        if( len % 2 == 0) {
            return findKth(nums, len / 2 , 0, len - 1);
        } else {
            return findKth(nums, len / 2 + 1, 0, len - 1);
        }
    }
    
    private int findKth(int[] nums, int k, int start, int end) {
        int pivotIdx = end;//(int)(Math.random() * (end + 1 - start)) + start;
        swap(nums, pivotIdx, end);
        
        int l = start, r = end;
        while(l < r) {
        	while(nums[l] < nums[end] && l < r) l++;
        	while(nums[r] >= nums[end] && l < r) r--;
        	
        	if(l == r) break;
        	if(l < r) {
        		swap(nums, l, r);
        	}
        }
        
        swap(nums, l, end);
        if(l == k - 1) return nums[l];
        else if(l < k - 1) {
        	return findKth(nums, k, l + 1, end);
        } else {
        	return findKth(nums, k, start, l - 1);
        }
        
    }
	
    private void swap(int[] nums, int l, int r) {
    	int temp = nums[l];
    	nums[l] = nums[r];
    	nums[r] = temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Median so = new Median();
		
		int[] A = {-1,-2,-3,-100,-1,-50};
		
		int n = so.median(A);
		System.out.println(n);
	}

}
