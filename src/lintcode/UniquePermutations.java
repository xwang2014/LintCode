package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class UniquePermutations {

	public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (nums == null)
			return ans;
		
		Collections.sort(nums);

		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> buffer = new ArrayList<Integer>();

		process(ans, nums, set, buffer);

		return ans;
	}

	private void process(ArrayList<ArrayList<Integer>> ans,
			ArrayList<Integer> nums, HashSet<Integer> set,
			ArrayList<Integer> buffer) {

		if (set.size() == nums.size()) {
			ans.add(new ArrayList<Integer>(buffer));
			return;
		}

		for (int i = 0; i < nums.size(); i++) {
			if (set.contains(i)) {
				continue;
			} else if (i > 0 && nums.get(i) == nums.get(i - 1) 
					&& !set.contains(i - 1) ) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
