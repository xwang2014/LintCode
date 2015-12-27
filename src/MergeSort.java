
public class MergeSort {
	
	int[] arr = null;
	
	
	public void MergeSort(int[] A) {
		arr = new int[A.length];

		int len = A.length;
		
		sort(A, 0, len - 1);
		
	}
	
	private void sort(int[] A, int start, int end) {
		if(start >= end) return; 
		
		int mid = start + (end - start) / 2;
		
		sort(A, start, mid);
		sort(A, mid + 1, end);
		
		merge(A, start, mid, mid + 1, end);
	}
	
	private void merge(int[] A, int s1, int e1, int s2, int e2) {
		for(int k = s1; k <= e2; k++) {
			arr[k] = A[k];
		}
		
		int i1 = s1, i2 = s2;
		int k = s1;
		while(i1 <= e1 && i2 <= e2) {
			if(arr[i1] < arr[i2]) {
				A[k++] = arr[i1++];
			} else {
				A[k++] = arr[i2++];
			}
		}
		for( ; i1 <= e1; ) {
			A[k++] = arr[i1++];
		}
		for( ; i2 <= e2; ) {
			A[k++] = arr[i2++];
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A1 = { 3, 3, 52, 1, -1};
		int[] A2 = { 3, 2, 5, 1, 4 };
		
		MergeSort so = new MergeSort();
		
		so.MergeSort(A1);
		so.MergeSort(A2);
		
		for(int i : A1) {
			System.out.print(i + "  ");
		}
		System.out.println();
		for(int j : A2) {
			System.out.print(j + "  ");
		}
	}

}
