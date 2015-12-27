package lintcode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class MajorityNumberIII {
	
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
        
        for(int i = 0; i < nums.size(); i++) {
            int cur = nums.get(i);
            
            if(map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                if(map.size() < k - 1) {
                    map.put(cur, 1);
                } else {
                    Iterator<Integer> it = map.keySet().iterator();
                    List<Integer> removeKey = new ArrayList<Integer>();
                    while(it.hasNext()) {
                        int key = it.next();
                        int value = map.get(key);
                        if(value == 1) {
                        	removeKey.add(key);
                            //map.remove(key);
                        } else {
                            map.put(key, value - 1);
                        }
                    }
                    for(int t : removeKey) map.remove(t);
                }
            }
        }
        
        Iterator<Integer> it = map.keySet().iterator();
        Hashtable<Integer, Integer> candidates = new Hashtable<Integer, Integer>();
        while(it.hasNext()) {
            candidates.put(it.next(), 0);
        }
        
        for(int n : nums) {
            if(candidates.containsKey(n)) {
                candidates.put(n, candidates.get(n) + 1);
            }
        }
        
        int maj = 0, count = 0;
        Iterator<Integer> iter = candidates.keySet().iterator();
        while(iter.hasNext()) {
            int key = iter.next();
            int value = candidates.get(key);
            
            if(value > count) {
                maj = key;
                count = value;
            }
        }
        
        return maj;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,1,2,3,2,3,3,4,4,4};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : arr) list.add(i);
		
		MajorityNumberIII so = new MajorityNumberIII();
		int maj  = so.majorityNumber(list, 3);
		System.out.println(maj);
	}

}
