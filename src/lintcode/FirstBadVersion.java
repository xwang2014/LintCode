package lintcode;


  class VersionControl {
      public static boolean isBadVersion(int k) {
    	  return true;
      };
  }
  // you can use VersionControl.isBadVersion(k) to judge wether 
  // the kth code version is bad or not.


public class FirstBadVersion {
	
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        
        int start = 0, end = n;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if(VersionControl.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if(VersionControl.isBadVersion(start)) return start;
        else return end;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
