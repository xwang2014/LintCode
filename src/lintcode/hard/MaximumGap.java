package lintcode.hard;

public class MaximumGap {
	
	// http://blog.csdn.net/u012162613/article/details/41936569
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
	class Bucket {
		int large;
		int small;
		public Bucket(int init) {
			large = init;
			small = init;
		}
		
		public void add(int val) {
			if(val > large) {
				large = val;
			}
			if(val < small) {
				small = val;
			}
		}
	}
	
    public int maximumGap(int[] nums) {
        // write your code here
    	if(nums == null || nums.length < 2) return 0;
    	if(nums.length == 2) return Math.abs(nums[0] - nums[1]);
    	
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        if(max - min == 0) return 0;
        
        // len of each bucket
        int len = (max - min) / nums.length + 1;
        
        // num of buckets
        int bucketNum =  (max - min) / len + 1;
        Bucket[] buckets = new Bucket[bucketNum];
        
        for(int i = 0; i < nums.length; i++) {
        	int n = nums[i];
        	int idx = (int)( (n - min) / (nums.length ) );
        	if(buckets[idx] == null) {
        		buckets[idx] = new Bucket(n);
        	} else {
        		buckets[idx].add(n);
        	}
        }
        
        int diff = len;
        int index = 0;
        int prev = -1;
        while(index < buckets.length) {
        	if(buckets[index] == null) {
        		index++;
        		continue;
        	}
        	
        	if(prev == -1) {
        		prev = index;
        		index++;
        		continue;
        	} else {
        		Bucket first = buckets[prev];
        		Bucket second = buckets[index];
        		diff = Math.max(diff, Math.abs(first.large - second.small));
        		
        		prev = index;
        		index++;
        	}
        }
        
        return diff;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumGap so = new MaximumGap();
		
		int[] num = { 3,2,1,4,3};
		
		int diff = so.maximumGap(num);
		System.out.println(diff);
	}

}
