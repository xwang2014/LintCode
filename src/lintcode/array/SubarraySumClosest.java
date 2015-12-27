package lintcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SubarraySumClosest {
	
    public static class Unit {
        public int sum;
        public int index;
        
        public Unit(int s, int i) {
            sum = s;
            index = i;
        }
    } 
     
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        if(nums == null || nums.length < 1) return ans;
        
        Unit[] sum = new Unit[nums.length + 1];
        
        int plus = 0;
        sum[0] = new Unit(plus, -1);
        for(int i = 0; i < nums.length; i++) {
            plus += nums[i];
            sum[i + 1] = new Unit(plus, i);
        }
        
        Arrays.sort(sum, new Comparator<Unit>() {
            public int compare(Unit u1, Unit u2) {
                if(u1.sum > u2.sum) return 1;
                if(u2.sum > u1.sum) return -1;
                return 0;
            }
        });
        
        int diff = Integer.MAX_VALUE;
        int start = -1, end = -1;
        for(int i = 0; i < sum.length - 1 ; i++) {
            int curDiff = Math.abs(sum[i].sum - sum[i+1].sum) ;
            if(curDiff <= diff) {
                start = Math.min(sum[i].index, sum[i+1].index) + 1;
                end = Math.max(sum[i].index, sum[i+1].index);
                diff = curDiff;
            }
        }
        
        ans.add(start);
        ans.add(end);
        
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -3, 1, 1, -3, 5 };
		int[] nums1 = { 2147483647 };
		
		SubarraySumClosest so = new SubarraySumClosest();
		
		ArrayList<Integer> ans = so.subarraySumClosest(nums);
		System.out.println(ans);
		
		ans = so.subarraySumClosest(nums1);
		System.out.println(ans);
	}

}
