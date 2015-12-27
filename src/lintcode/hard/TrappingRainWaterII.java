package lintcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII {
	
	class Cell {
		int x, y;
		int height;
		int waterLevel = 0; //
		boolean visited = false;
		
		public Cell(int xx, int yy, int h) {
			x = xx;
			y = yy;
			this.height = h;
		}
	}
	
	PriorityQueue<Cell> heap = null;
    public int trapRainWater(int[][] heights) {
        // write your code here
    	if(heights == null || heights.length <= 1) return 0;
    	
    	heap = new PriorityQueue<Cell>(1, new Comparator<Cell>(){

			@Override
			public int compare(Cell arg0, Cell arg1) {
				if(arg0.height < arg1.height) return -1;
				if(arg0.height > arg1.height) return 1;
				return 0;
			}
    		
    	});
    	
    	Cell[][] cells = new Cell[heights.length][heights[0].length];
    	
    	for(int i = 0; i < heights.length; i++) {
    		for(int j = 0; j < heights[i].length; j++) {
    			Cell c = new Cell(i, j, heights[i][j]);
    			cells[i][j] = c;
    			if(i == 0 || j == 0 || i == heights.length - 1 
    					|| j == heights[i].length - 1) {
    				heap.offer(c);
    			}
    		}
    	}

    	while(!heap.isEmpty()) {
    		Cell start = heap.poll();
    		start.visited = true;
    		
    		spread(cells, start.x + 1, start.y, start.height);
    		spread(cells, start.x - 1, start.y, start.height);
    		spread(cells, start.x, start.y + 1, start.height);
    		spread(cells, start.x, start.y - 1, start.height);
    	}
    	
    	int water = 0;
    	
    	for(int i = 0; i < heights.length; i++) {
    		for(int j = 0; j < heights[i].length; j++) {
    			Cell c = cells[i][j];
    			
    			if(c.waterLevel <= c.height) continue;
    			
    			water += c.waterLevel - c.height;
//    			System.out.println("Cell " + c.x + " " + c.y + " has " 
//    					+ c.height + "/" + c.waterLevel);
    		}
    	}
    	
    	return water;
    }
    
    private void spread(Cell[][] cells, int x, int y, int waterLevel) {
    	if(x < 0 || y < 0 || x >= cells.length 
    			|| y >= cells[0].length)  {
    		return;
    	}
    	
    	Cell cur = cells[x][y];
    	if(cur.visited) return;
    	
    	
    	if(cur.height >= waterLevel) {
    		cur.waterLevel = cur.height;
    		heap.offer(cur);
    		return;
    	}
    	
    	cur.waterLevel = waterLevel;
    	cur.visited = true;
    	
    	spread(cells, x + 1, y, waterLevel);
    	spread(cells, x - 1, y, waterLevel);
    	spread(cells, x, y + 1, waterLevel);
    	spread(cells, x, y - 1, waterLevel);
    }
	
//    // Wrong 	
//    public int trapRainWater(int[][] heights) {
//        // write your code here
//        if(heights == null) return 0;
//        int r = heights.length;
//        int c = heights[0].length;
//        if(r <= 1 || c <= 1) return 0;
//        
//        int[][] up = new int[r][c];
//        int[][] left = new int[r][c];
//        int[][] down = new int[r][c];
//        int[][] right = new int[r][c];
//        
//        for(int i = 0; i < r; i++) {
//            for(int j = 0; j < c; j++) {
//                if(i > 0) {
//                    up[i][j] = Math.max(up[i - 1][j], heights[i][j]);
//                } else up[i][j] = heights[i][j];
//                
//                if(j > 0) {
//                    left[i][j] = Math.max(left[i][j - 1], heights[i][j]);
//                } else left[i][j] = heights[i][j];
//            }
//        }
//        
//        for(int i = r - 1; i >= 0; i--) {
//            for(int j = c - 1; j >= 0; j--) {
//                if(i < r - 1) {
//                    down[i][j] = Math.max(down[i + 1][j], heights[i][j]);
//                } else down[i][j] = heights[i][j];
//                
//                if(j < c - 1) {
//                    right[i][j] = Math.max(right[i][j + 1], heights[i][j]);
//                } else right[i][j] = heights[i][j];
//            }
//        }
//        
//        int sum = 0;
//        for(int i = 0; i < r; i++) {
//            for(int j = 0; j < c; j++) {
//                if(i == 0 || j == 0 || i == r - 1 || j == c - 1) continue;
//                
//                int water = 0;
//                int h = Integer.MAX_VALUE;
//                h = Math.min(h, up[i - 1][j]);
//                h = Math.min(h, left[i][j - 1]);
//                h = Math.min(h, down[i + 1][j]);
//                h = Math.min(h, right[i][j + 1]);
//                water = Math.max(water, h - heights[i][j]);
//                if(water > 0) {
//                	System.out.println(water + "  at " + i + "," + j);
//                }
//                sum += water;
//            }
//        }
//        
//        return sum;
//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWaterII so = new TrappingRainWaterII();
		
		int[][] w = {
				{19,13,63,93,76},
				{68,8,37,70,97},
				{80,38,98,10,52},
				{23,61,5,20,54},
				{79,88,51,40,26},
				{10,77,24,34,29},
				{87,59,50,3,37},
				{25,0,87,77,70},
				{72,47,98,41,48}
				
		};
		
		int[][] w2 = {
				{79,88,51,40,26},
				{10,177,100,134,29},
				{87,159,50,113,37},
				{25,100,187,177,70},
				{72,47,98,41,48}
		};
		
		int a = so.trapRainWater(w2);
		
		System.out.println(a);
	}

}
