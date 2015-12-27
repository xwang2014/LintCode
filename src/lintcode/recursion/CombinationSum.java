package lintcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
    List<List<Integer>> res = null;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        res = new  ArrayList<List<Integer>>();
        
        if(candidates == null || candidates.length == 0) return res;
        
        helper(list, target, candidates, 0);
        
        return res;
    }
    
    private void helper(ArrayList<Integer> list, int target, int[] candidates, int idx) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = idx; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(list, target - candidates[i], candidates, i);
            list.remove(list.size() - 1);
        }
    }

	public static void main(String[] args) {
		
		int[] candidates = { 2, 3, 5 };

		CombinationSum cs = new CombinationSum();
		
		System.out.println(cs.combinationSum(candidates, 7));
		
		char[] arr = new char[3];
		String word = new String(arr);
		List<String> list = new ArrayList<String>();
		
	}

}
