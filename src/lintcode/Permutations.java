package lintcode;

import java.util.ArrayList;
import java.util.HashSet;

public class Permutations {

	    /**
	     * @param nums: A list of integers.
	     * @return: A list of permutations.
	     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // 
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if(nums == null) return ans;
        
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        
        process(ans, nums, set, buffer);
        
        return ans;
    }
	    
    private void process(ArrayList<ArrayList<Integer>> ans, 
            ArrayList<Integer> nums, HashSet<Integer> set,
            ArrayList<Integer> buffer) {
        
            if(set.size() == nums.size()) {
                ans.add(new ArrayList<Integer>(buffer));
                return;
            } 
            
            for(int i = 0; i < nums.size(); i++) {
                if(set.contains(i)) {
                    continue;
                } else {
                    set.add(i);
                    buffer.add(nums.get(i));
                    process(ans, nums, set, buffer);
                    set.remove(i);
                    buffer.remove(buffer.size() - 1);
                }
            }
            
        }

}
