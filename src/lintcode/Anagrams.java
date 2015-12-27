package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class Anagrams {
    public List<String> anagrams(String[] strs) {
        // write your code here
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            
            if(map.containsKey(sorted)) {
                map.get(sorted).add(strs[i]);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(sorted, list);
            }
        }
        
        Iterator<Entry<String, List<String>>> it = map.entrySet().iterator();
        List<String> ans = null;
        while(it.hasNext()) {
            Entry<String, List<String>> entry = it.next();
            if(entry.getValue().size() > 1) {
                ans = entry.getValue();
                break;
            }
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
