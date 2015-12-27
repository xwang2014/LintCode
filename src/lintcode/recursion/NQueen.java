package lintcode.recursion;

import java.util.ArrayList;

public class NQueen {
	
	ArrayList<ArrayList<String>> res = null;
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
    	res = new ArrayList<ArrayList<String>>();
    	char[][] board = new char[n][n];
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			board[i][j] = '.';
    		}
    	}
    	
    	process(board, 0);
    	
    	return res;
    }

    private void process(char[][] board, int index) {
    	int n = board.length;
    	if(index == n) {
    		getResult(board);
    		return;
    	}
    	
    	for(int col = 0; col < n; col++) {
    		if(valid(board, index, col)) {
	    		board[index][col] = 'Q';
	    		process(board, index + 1);
	    		board[index][col] = '.';
    		}
    	}
    }
    
    private void getResult(char[][] board) {
    	ArrayList<String> list = new ArrayList<String>();
    	
    	for(int i = 0; i < board.length; i++) {
    		String cur = new String(board[i]);
    		list.add(cur);
    	}
    	
    	res.add(list);
    }
    
    private boolean valid(char[][] board, int row, int col) {
    	int n = board.length;
    	for(int i = 0; i < n; i++) {
    		if(board[row][i] == 'Q') return false;
    	}
    	
    	for(int i = 0; i < n; i++) {
    		if(board[i][col] == 'Q') return false;
    	}
    	
    	for(int i = 0; i < n; i++) {
    		if(i == row) continue;
    		int j = row + col - i;
    		if(j >= 0 && j < n) {
    			if(board[i][j] == 'Q') return false;
    		}
    	}
    	
    	for(int i = 0; i < n; i++) {
    		if(i == row) continue;
    		int j = col - row + i;
    		if(j >= 0 && j < n)	{
    			if(board[i][j] == 'Q') return false;
    		}
    	}
    	
    	return true;
    }
    
	public static void main(String[] args) {
		NQueen so = new NQueen();
		
		System.out.println(so.solveNQueens(4));

	}

}
