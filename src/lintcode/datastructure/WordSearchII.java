package lintcode.datastructure;

import java.util.ArrayList;
import java.util.HashSet;

public class WordSearchII {
	
    HashSet<String> set = null; 
    HashSet<String> collect = null;
    ArrayList<String> ans = null;
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ans = new ArrayList<String>();
        if(board == null || words == null) return ans;
        
        int maxLen = -1;
        set = new HashSet<String>();
        collect = new HashSet<String>();
        for(String s : words) {
            if(s.length() > maxLen) {
                maxLen = s.length();
            }
            set.add(s);
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        // 
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                process(visited, i, j, maxLen, "", board);
            }
        }
        
        for(String str : collect) {
            ans.add(str);
        }
        
        return ans;
    }
    
    private void process(boolean[][] visited, int r, int c, 
                int stepLeft, String word, char[][] board) {
        
        String cur = word + board[r][c];
        if(set.contains(cur)) {
            collect.add(cur);
        }
        if(stepLeft == 0) return;
        
        visited[r][c] = true;
        if(r > 0 && !visited[r-1][c]) {
            process(visited, r-1, c, stepLeft - 1, new String(cur), board);
        } 
        if(c > 0 && !visited[r][c - 1]) {
            process(visited, r, c - 1, stepLeft - 1, new String(cur), board);
        }
        if(r < visited.length - 1 && !visited[r+1][c]) {
            process(visited, r + 1, c , stepLeft - 1, new String(cur), board);
        }
        if(c < visited[0].length - 1 && !visited[r][c + 1]) {
            process(visited, r, c + 1, stepLeft - 1, new String(cur), board);
        }
        
        visited[r][c] = false;
    }

	public static void main(String[] args) {
		// "doaf","agai","dcan"
		char[][] board = {
				{'d', 'o', 'a', 'f' },
				{'a', 'g', 'a', 'i' },
				{'d', 'c', 'a', 'n' },
		};
		
		String[] n = {"dog","dad","dgdg","can","again"};
		ArrayList<String> dict = new ArrayList<String>();
		for(String s : n) dict.add(s);
		
		WordSearchII so = new WordSearchII();
		ArrayList<String> ans = so.wordSearchII(board, dict);
		
		System.out.println(ans);
	}

}
