package lintcode.datastructure;

public class WordSearch {
	
    boolean[][] visited = null; 
    boolean found ;
    public boolean exist(char[][] board, String word) {
        // write your code here
        found = false;
        visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                process(board, word, 0, i, j);
            }
        }
        
        return found;
    }
    
    private void process(char[][] board, String word, 
        int index, int row, int col) {
            
        if(found) return;
        
        char cur = word.charAt(index);
        if(board[row][col] != cur) return;
        
        if(index == word.length() - 1) {
        	found = true;
        	return;
        }
        visited[row][col] = true;
        
        if(row - 1 >= 0 && !visited[row - 1][col]) {
            process(board, word, index + 1, row - 1, col);
        }
        if(row + 1 < board.length && !visited[row + 1][col]) {
            process(board, word, index + 1, row + 1, col);
        }
        if(col - 1 >= 0 && !visited[row ][col - 1]) {
            process(board, word, index + 1, row, col - 1);
        }
        if(col + 1 < board[0].length && !visited[row ][col + 1]) {
            process(board, word, index + 1, row, col + 1);
        }
        
        visited[row][col] = false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { 
				{ 'a', 'b', 'c' },
				{ 'a', 'e', 'd' },
				{ 'a', 'f', 'g' }
		};
		
		WordSearch ws = new WordSearch();
		boolean flag = ws.exist(board, "abcdefg");
		System.out.println(flag);
	}

}
