package lintcode.hard;

import java.util.Arrays;

public class PostOfficeProblem {
	
    // f[i][t] means the first i locations, there are t post offices and the minimum distance is f[i][t]
    // f[i][t] = f[x][t - 1] + dist[x + 1, i]    x from t - 1 to i - 1
	
	// dist[i, j] means build one post office between i to j. The ideal position is
	// (i + j) / 2 because building in the middle has the least distance

	
    public int postOffice(int[] A, int k) {
        // Write your code here
    	if(A == null || A.length < 1) return 0;
    	if(k >= A.length) return 0;
    	
    	Arrays.sort(A);
    	
    	int[][] f = new int[A.length][k + 1];
    	
    	int[][] dists = new int[A.length][A.length];
    	for(int i = 0; i < A.length; i++) {
    		for(int j = i; j < A.length; j++) {
    			dists[i][j] = getDist(A, i, j);
    		}
    	}
    	
    	
    	for(int i = 0; i < A.length; i++) {
    		f[i][1] = dists[0][i];
    	}
    	
    	for(int i = 0; i < A.length; i++) {
    		for(int t = 2; t <= k; t++) {
    			int val = -1;
    			for(int x = 0; x <= i - 1; x++) {
    				int temp = f[x][t - 1] + dists[x + 1][i];
    				if(val == -1) {
    					val = temp;
    				} else {
    					val = Math.min(val, temp);
    				}
    			}
    			f[i][t] =  val;
    		}
    	}
    	
    	return f[A.length - 1][k];
    } 
    
    private int getDist(int[] A, int start, int end) {
    	if(start > end) return 0;
    	
    	int mid = (start + end) / 2;
    	int cost = 0;
    	for(int j = start; j <= end; j++) {
    		cost += Math.abs(A[j] - A[mid]);
    	}
    	
    	return cost;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostOfficeProblem so = new PostOfficeProblem();
		
		//int[] A = {112,122,360,311,85,225,405,53,405,43,342,13,588,424,299,37,104,289,404,414};
		int[] A = {1, 2, 3, 4, 10};
		int f = so.postOffice(A, 3);
		System.out.println(f);
	}

}
