package lintcode.quicksort;

import java.util.ArrayList;

public class KthLargestNumber {
	
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        
        if(numbers == null || numbers.size() < 1) return -1;
        
        int start = 0, end = numbers.size() - 1;
        
        while(start < end) {
            int partition = partition(numbers, start, end);
            
            if(partition == k - 1) {
                return numbers.get(partition);
            } else if(partition > k - 1) {
                end = partition - 1;
            } else { //partition < k
                start = partition + 1;
            }
        }
        
        return numbers.get(start);
    }
    
    private int partition(ArrayList<Integer> numbers, int start, int end) {
        if(start == end) return start;
        
        int pivot = start + (end - start) / 2;
        int pivotNum = numbers.get(pivot);
        
        swap(numbers, pivot, end);
        
        int sortIndex = start, pt = start;
        while(pt < end) {
            if(numbers.get(pt) >= pivotNum) {
                swap(numbers, pt, sortIndex);
                sortIndex++;
            }
            
            pt++;
        }
        
        swap(numbers, end, sortIndex);
        
        return sortIndex;
    }
    
    private void swap(ArrayList<Integer> numbers, int i, int j) {
        int temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthLargestNumber so = new KthLargestNumber();
		
		int[] num = {1,2,3,4,5,6,8,9,10,7};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : num) list.add(i);
		
		int ans = so.kthLargestElement(10, list);
		
		System.out.println(ans);
		
	}

}
