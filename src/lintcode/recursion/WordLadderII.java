package lintcode.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	
    List<List<String>> res = null;
    List<String> list = null;
    Queue<String> queue = null;
    HashMap<String, List<String> > prevs = null;
    HashMap<String, Integer> levels = null;
      
    public List<List<String>> findLadders(String start, String end, 
        Set<String> dict) {
        // write your code here
        res = new ArrayList<List<String> >();
        list = new ArrayList<String>();
        queue = new LinkedList<String>();
        prevs = new HashMap<String, List<String> >();
        levels = new HashMap<String, Integer>();
        
        queue.offer(start);
       
        prevs.put(start, new ArrayList<String>());
        levels.put(start, 0);
        
        BFS(dict, start, end);
        
        return res;
    }
    
    private void getResult(String word, String start) {
        list.add(word);
        
        if(word.equals(start)) {
            ArrayList<String> ans = new ArrayList<String>(list);
            Collections.reverse(ans);
            res.add(ans);
        }
        
        List<String> prev = prevs.get(word);
        for(String cur : prev) {
            getResult(cur, start);
        }
        
        list.remove(list.size() - 1);
    }
    
    private void BFS(Set<String> dict, String start, String end) {
        
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size(); 
            
            level++;
            for(int i = 0; i < size; i++) {
                String cur = queue.poll();
                if(cur.equals(end)) {
                    getResult(cur, start);
                    return;
                }
                
                for(int j = 0; j < cur.length(); j++) {
                    char[] arr = cur.toCharArray();
                    for(char k = 'a'; k <= 'z'; k++) {
                        if(k == arr[j]) continue;
                        
                        arr[j] = k;
                        String newWord = new String(arr);
                        if(dict.contains(newWord)) {
                            if(levels.containsKey(newWord)) {
                                if(levels.get(newWord) == level + 1) {
                                    prevs.get(newWord).add(cur);
                                }
                            } else {
                                levels.put(newWord, level + 1);
                                List<String> prev =  new ArrayList<String>();
                                prev.add(cur);
                                prevs.put(newWord, prev);
                                queue.offer(newWord);
                            }
                            
                        }
                    }
                }
                
            }
            
            
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		dict.add("a"); dict.add("b"); dict.add("c");
		
		WordLadderII w = new WordLadderII();
		
		System.out.println(w.findLadders("a", "c", dict));
	}

}
