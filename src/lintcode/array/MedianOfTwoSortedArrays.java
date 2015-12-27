package lintcode.array;

public class MedianOfTwoSortedArrays {
	/*
    public double findMedianSortedArrays(int[] A, int[] B) {
        if(A == null || B == null || A.length < 1 
            || B.length < 1) {
                return 0;
            }
            
        int len = A.length + B.length;
        
        if(len % 2 == 0) {
            int one = findKthNum(A, 0, B, 0, len / 2);
            int two = findKthNum(A, 0, B, 0, len / 2 + 1);
            return ((double)(one + two)) / 2;
        } else {
            return (double)findKthNum(A, 0, B, 0, len / 2 + 1);
        }
    }
    
    private int findKthNum(int[] A, int startA, int[] B, int startB, int k) {
        // make sure A is shorter array
        if(A.length - startA > B.length - startB) {
            return findKthNum(B, startB, A, startA, k);
        }
        
        // check if one of the arrays are up
        if(A.length == startA) return B[startB + k - 1];
        if(B.length == startB) return A[startA + k - 1];
        
        // check k 
        if(k == 1) {
            return A[startA] <= B[startB] ? A[startA] : B[startB];
        }
        
        // 
        int mid = k / 2;
        int pa = (A.length - 1 - startA + 1 < mid) ? A.length - 1 - startA + 1 : mid;
        int pb = k - pa;
        
        if(A[startA + pa - 1] < B[startB + pb - 1]) {
            return findKthNum(A, startA + pa, B, startB, k - pa);
        } else if(A[startA + pa - 1] > B[startB + pb - 1]) {
            return findKthNum(A, startA, B, startB + pb, k - pb);
        } else {
            return A[pa - 1];
        }
    }
    */
	
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        if(A == null && B == null) return 0;
        if(A.length == 0 && B.length == 0) return 0;
        
        int lenA = A.length, lenB = B.length;
        
        double d = 0;
        if( (lenA + lenB) % 2 == 1) {
            int middle = findKth(A, 0, A.length - 1, 
                B, 0, B.length - 1, (lenA + lenB) / 2 + 1);
            d = middle;
        } else {
            int m1 = findKth(A, 0, A.length - 1, 
                B, 0, B.length - 1, (lenA + lenB) / 2);
            int m2 = findKth(A, 0, A.length - 1, 
                B, 0, B.length - 1, (lenA + lenB) / 2 + 1);
            d = ((double)m1 + m2) / 2;
        }
        
        return d;
    }
    
    private int findKth(int[] A, int aleft, int aright, 
    		int[] B, int bleft, int bright, int k) {
        // A is shorter
        if(aright - aleft + 1 > bright - bleft + 1) {
            return findKth(B, bleft, bright, A, aleft, aright, k);
        }
        
        if(aleft > aright) {
            return B[bleft + k - 1];
        }
        if(bleft > bright) {
            return A[aleft + k - 1];
        }
        
        if(k == 1) {
            return Math.min(A[aleft], B[bleft]);
        }
        
        int halfAIdx = Math.min(k / 2, aright - aleft + 1);
        int halfAval = A[aleft + halfAIdx - 1];
        
        int halfBIdx = k - halfAIdx;
        int halfBval = B[bleft + halfBIdx - 1];
        
        if(halfAval <= halfBval) {
            return findKth(A, aleft + halfAIdx, aright, B, bleft, bright, halfBIdx);
        } else {
            return findKth(A, aleft, aright, B, bleft + halfBIdx, bright, halfAIdx);
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 2, 3, 4, 5, 6};
		int[] B = {2, 3, 4, 5};
		MedianOfTwoSortedArrays so = new MedianOfTwoSortedArrays();
		
		double ans = so.findMedianSortedArrays(A, B);
		
		System.out.println(ans);
		
		String str = "this is a word";
		
	}

}
