package lintcode;

public class InterleavingPositiveAndNegativeNumbers {
	
    public void rerange(int[] A) {
        // write your code here
        if(A == null || A.length <= 1) return;
        
        
        if(A.length % 2 == 0) {
            int neg = 0, pos = 1;
            boolean flag = true;
            while(flag) {
                while(A[neg] < 0) {
                    neg += 2;
                    if(neg >= A.length) {
                        flag = false;
                        break;
                    }
                }
                while(A[pos] > 0) {
                    pos += 2;
                    if(pos >= A.length) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag) 
                	swap(A, pos, neg);
            }
        } else {
            int negCount = 0, posCount = 0;
            for(int i = 0; i < A.length; i++) {
                if(A[i] > 0) posCount++;
                else negCount--;
            }
            
            int pos = 0, neg = 0;
            if(negCount > posCount) {
                neg = 0;
                pos = 1;
            } else {
                pos = 0;
                neg = 1;
            }
            
            boolean flag = true;
            while(flag) {
                while(A[neg] < 0) {
                    neg += 2;
                    if(neg >= A.length) {
                        flag = false;
                        break;
                    }
                }
                while(A[pos] > 0) {
                    pos += 2;
                    if(pos >= A.length) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag)
                	swap(A, pos, neg);
            }
            
        }
   }
   
   private void swap(int[] A, int pos, int neg) {
       int temp = A[pos];
       A[pos] = A[neg];
       A[neg] = temp;
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-1, -2, -3, 4, 5, 6 };
		
		InterleavingPositiveAndNegativeNumbers so = 
				new InterleavingPositiveAndNegativeNumbers();
		
		so.rerange(A);
		
		for(int t : A)
			System.out.println(t);
		
	}

}
