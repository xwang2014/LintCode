package lintcode;

import java.util.ArrayList;

public class SearchForARange {
	// http://www.lintcode.com/en/problem/search-for-a-range/#
	
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(A == null) return ans;
        
        int first = findFirstIndex(A, target);
        int last = findLastIndex(A, target);
        
        ans.add(first);
        ans.add(last);
        
        return ans;
    }
    
    private int findFirstIndex(ArrayList<Integer> A, int target) {
        if(A == null || A.size() < 1) return -1;
        
        int head = 0;
        int tail = A.size() - 1;
        
        while(head + 1 < tail) {
            int midIdx = head + (tail - head) / 2;
            int midVal = A.get(midIdx);
            
            if(midVal == target) {
                tail = midIdx;
            } else if(midVal < target) {
                head = midIdx;
            } else {
                tail = midIdx;
            }
        }
        
        if(A.get(head) == target) return head;
        else if(A.get(tail) == target) return tail;
        
        return -1;
    }
    
    private int findLastIndex(ArrayList<Integer> A, int target) {
        if(A == null || A.size() < 1) return -1;
        
        int head = 0;
        int tail = A.size() - 1;
        
        while(head + 1 < tail) {
            int midIdx = head + (tail - head) / 2;
            int midVal = A.get(midIdx);
            
            if(midVal == target) {
                head = midIdx;
            } else if(midVal < target) {
                head = midIdx;
            } else {
                tail = midIdx;
            }
        }
        
        if(A.get(tail) == target) return tail;
        else if(A.get(head) == target) return head;
        
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
