package lintcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber {
	
    public String largestNumber(int[] num) {
        // write your code here
        StringBuffer sb = new StringBuffer();
        
        PriorityQueue<String> queue = new PriorityQueue<String>(1, 
        				new Comparator<String>() {

							@Override
							public int compare(String arg0, String arg1) {
//								int idx0 = 0, idx1 = 0;
//								while(idx0 < arg0.length() || idx1 < arg1.length()) {
//									char a = arg0.charAt(idx0);
//									char b = arg1.charAt(idx1);
//									if(a == b) {
//										if(idx0 < arg0.length() - 1) idx0++;
//										if(idx1 < arg1.length() - 1) idx1++;
//									} else {
//										if(a < b) return 1;
//										if(a > b) return -1;
//									}
//											
//								}
//								return 0;
								return (arg1 + arg0).compareTo((arg0 + arg1));
							}
        
        });
        
        for(int i = 0; i < num.length; i++) {
        	String cur = num[i] + "";
        	queue.offer(cur);
        }
        
        while(!queue.isEmpty()) {
        	sb.append(queue.poll());
        }
        
        String ans = sb.toString();
        int i = 0;
        for(i = 0; i < ans.length(); i++) {
            if(ans.charAt(i) != '0') {
                break;
            }
        }
        
        ans = ans.substring(i, ans.length());
        
        
        return ans.length() == 0 ? "0" : ans;
    }

	public static void main(String[] args) {
		int[] num = {4,1, 45};

		LargestNumber so = new LargestNumber();
		
		System.out.println(so.largestNumber(num));
	}

}
