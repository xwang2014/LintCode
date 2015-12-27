package lintcode;

import java.util.ArrayList;

public class MajorityNumberII {
	
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() <= 2) return -1;
        
        int num0 = nums.get(0), count0 = 1;
        int num1 = -1, count1 = 0;
        int i = 1;
        for(i = 1; i < nums.size(); i++) {
            int cur = nums.get(i);
            
            if(count0 == 0 && cur != num1) {
                num0 = cur;
                count0 = 1;
            } else if(count1 == 0 && cur != num0) {
                num1 = cur;
                count1 = 1;
            } else if(cur == num0) {
                count0++;
            } else if(cur == num1) {
                count1++;
            } else {
                count0--;
                count1--;
            }
        }
        
        count0 = 0;
        count1 = 0;
        for(int j = 0; j < nums.size(); j++) {
            int cur = nums.get(j);
            
            if(cur == num0) {
                count0++;
            } else if(cur == num1) {
                count1++;
            }
        }
        
        if(count0 > count1) return num0;
        else return num1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,1,1,2,2,3,3,4,4,4};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : arr) list.add(i);
		
		
		MajorityNumberII so = new MajorityNumberII();
		int maj = so.majorityNumber(list);
		System.out.println(maj);
	}

}
