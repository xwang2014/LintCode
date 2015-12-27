package lintcode.hard;

import java.util.LinkedList;

public class CopyBooks {
	
//    public int copyBooks(int[] pages, int k) {
//        // write your code here
//    	int max = 0;
//    	
//    	LinkedList<Integer> list = new LinkedList<Integer>();
//    	
//    	for(int i = 0; i < pages.length; i++) {
//    		list.add(pages[i]);
//    		max = Math.max(max, pages[i]);
//    	}
//    	
//    	for(int i = 0; i < pages.length - k; i++) {
//    		// merge n - k times
//    		
//    		// find smallest neighboor
//    		int index = 0, value = list.get(0) + list.get(1);
//    		for(int j = 1; j < list.size() - 1; j++) {
//    			int val = list.get(j) + list.get(j + 1);
//    			if(val < value) {
//    				index = j;
//    				value = val;
//    			}
//    		}
//    		
//    		// merge two neighbors
//    		max = Math.max(value, max);
//    		list.set(index, value);
//    		list.remove(index + 1);
//    	}
//    	
//    	return max;
//    }
    
    //f[i][k]  books [0, i] split to k person
    
    //f[i][k] = Math.max(f[x][k - 1], cost(x + 1, i) )  x from k - 1 to i - 1
      
    public int copyBooks(int[] pages, int k) {
        // write your code here
        
        int[][] f = new int[pages.length][k + 1];
        
        int max = 0;
        int cost = 0;
        for(int i = 0; i < pages.length; i++) {
            max = Math.max(max, pages[i]);
            cost += pages[i];
            f[i][1] = cost;
        }
        
        if(k >= pages.length) return max;
        
        for(int t = 2; t <= k; t++) {
            for(int i = t; i < pages.length; i++) {
                // f[i][t] = math.max( f[x][t - 1], cost(x + 1, i) )
                int val = -1;
                for(int x = t - 1; x <= i - 1; x++) {
                    int curCost = getCost(pages, x + 1, i);
                    if(val == -1) {
                    	val = Math.max(f[x][t - 1], curCost);
                    } else {
                    	val = Math.min(Math.max(f[x][t - 1], curCost), val);
                    }
                }
                f[i][t] = val;
            }
        }
        
        return f[pages.length - 1][k];
    }
    
    private int getCost(int[] pages, int start, int end) {
        int cost = 0;
        for(int i = start; i <= end; i++) {
            cost += pages[i];
        }
        return cost;
    }
    
    
    public int copyBooks2(int[] pages, int k) {
        // write your code here
        if(pages == null || pages.length < 1) return 0;
        
        int len = pages.length;
        int[][] time = new int[len][len];
        // O(n^2)
        int maxPage = 0;
        for(int i = 0; i < len; i++) {
            int t = 0;
            for(int j = i; j < len; j++) {
                t += pages[j];
                time[i][j] = t;
            }
            maxPage = Math.max(maxPage, pages[i]);
        }
        if(k >= pages.length) return maxPage;
        
        // f[i][k]  time needed, first i books, distribute to k people
        // f[i][k] = f[x][k - 1] + time[x+1][i]    
        
        int[][] f = new int[len][k];
        for(int i = 0; i < len; i++) {
        	f[i][0] = (i > 0 ? f[i - 1][0] : 0) + pages[i]; 
        }
        
        
        for(int i = 1; i < len; i++) {
            for(int t = 1; t < Math.min(k, i); t++) {
                int val = -1;
                for(int j = 0; j < i; j++) {
                    if(val == -1) {
                        val = Math.max(f[j][t - 1], time[j + 1][i]);
                    } else {
                        int tmp = Math.max(f[j][t - 1], time[j + 1][i]);
                        val = Math.min(val, tmp);
                    }
                }
                f[i][t] = val;
            }
        }
        
        return f[len - 1][k - 1];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] books = {3,2,4}; //{1,9,7,3,4,7};
		
		CopyBooks so = new CopyBooks();
		
		int val = so.copyBooks2(books, 2);
		
		System.out.println(val);
	}

}
