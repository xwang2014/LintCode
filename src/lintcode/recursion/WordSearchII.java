package lintcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordSearchII {
	
	class TrieNode {
		char val;
		HashMap<Character, TrieNode> map;
		
		public TrieNode(char c) {
			this.val = c;
			map = new HashMap<Character, TrieNode>();
		}
	}
	
	private TrieNode root = new TrieNode(' ');
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if(board == null || board.length < 1 
            || words == null || words.length < 1) {
                return res;
            }
            
        // Put words in a set
        buildTrie(words);
        
        HashSet<String> found = new HashSet<String>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                process(board, visited, i, j, root, found, "");
            }
        }
        
        for(String w : found) {
            res.add(w);
        }
        
        return res;
    }
    
    private void buildTrie(String[] words) {
    	for(String w : words) {
    		TrieNode r = root;
    		for(int i = 0; i < w.length(); i++) {
    			char c = w.charAt(i);
    			if(!r.map.containsKey(c)) {
    				TrieNode n = new TrieNode(c);
    				r.map.put(c, n);
    			}
    			r = r.map.get(c);
    			
    			if(i == w.length() - 1) {
    				r.map.put('$', null);
    			}
    		}
    	}
    }
    
    private void process(char[][] board, boolean[][] visited, int x, int y,
        TrieNode node, HashSet<String> found, String cur) {
    
        if(visited[x][y]) return;
        if(!node.map.containsKey(board[x][y])) {
        	return;
        } else {
        	node = node.map.get(board[x][y]);
        }
        
        cur = cur + board[x][y];
        visited[x][y] = true;
        if(node.map.containsKey('$')) {
            found.add(cur);
        }
        
        if(x > 0 && !visited[x-1][y]) process(board, visited, x - 1, y, node, found, cur);
        if(y > 0 && !visited[x][y-1]) process(board, visited, x, y - 1, node, found, cur);
        if(x < board.length-1 && !visited[x+1][y]) process(board, visited, x + 1, y, node, found, cur);
        if(y < board[0].length-1 && !visited[x][y+1]) process(board, visited, x, y + 1, node, found, cur);        
        cur = cur.substring(0, cur.length() - 1);
        visited[x][y] = false;
    }	

	public static void main(String[] args) {
		// [], []
		long tstart = System.currentTimeMillis();
		
		String[] bs = { "bbaaba","bbabaa","bbbbbb","aaabaa","abaabb" };
		String[] words = { "abbbababaa" };

		char[][] board = new char[5][6];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 6; j++) {
				board[i][j] = bs[i].charAt(j);
			}
		}
		
		WordSearchII so = new WordSearchII();
		
		List<String> list = so.findWords(board, words);
		System.out.println(list);
		
		long tend = System.currentTimeMillis();
		System.out.println( (tend - tstart) / 1000 );
	}

}
