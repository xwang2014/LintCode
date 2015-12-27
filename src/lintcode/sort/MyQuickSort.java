package lintcode.sort;

public class MyQuickSort {
	
	
	public void sort(int[] A) {
		qSort(A, 0, A.length - 1);
	}
	
	public void qSort(int[] A, int low, int high) {
		if(low >= high) return;
		
		int partition = partition(A, low, high);
		qSort(A, low, partition - 1);
		qSort(A, partition + 1, high);
	}
	
	private int partition(int[] A, int start, int end) {
		
		int pivot = start + (end - start) / 2;
		int pVal = A[pivot];
		A[pivot] = A[end];
		A[end] = pVal;
		
		int storeIndex = start, i = start;
		while(i < end) {
			if(A[i] <= pVal) {
				int temp = A[storeIndex];
				A[storeIndex] = A[i];
				A[i] = temp;
				
				storeIndex++;
			}
			i++;
		}
		
		A[end] = A[storeIndex];
		A[storeIndex] = pVal;
		
		
		return storeIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQuickSort so = new MyQuickSort();
		
		int[] A1 = { 1, 2, 5, 4, 200, 7 };
		so.sort(A1);
		for(int i : A1) {
			System.out.println(i);
		}
	}

}
