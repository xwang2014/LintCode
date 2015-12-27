package lintcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumber {
	
    public long kthPrimeNumber(int k) {
        // write your code here
        PriorityQueue<Long> queue = new PriorityQueue<Long>(1, new Comparator<Long>() {
                public int compare(Long l1, Long l2) {
                    if(l1 > l2) return 1;
                    if(l1 < l2) return -1;
                    return 0;
                }
            });
        HashSet<Long> set = new HashSet<Long>();
        long[] seeds = { 3L, 5L, 7L };
        queue.offer((long)1);
        
        int i = 0;
        long prime = -1;
        while(i <= k) {
            prime = queue.poll();
            
            for(long seed : seeds) {
            	if(!set.contains(prime * seed)) {
            		queue.offer(prime * seed);
            		set.add(prime * seed);
            	}
            }
            
            i++;
        }
        
        return prime;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UglyNumber s = new UglyNumber();
		
		for(int i = 1; i < 12; i++) {
			long l = s.kthPrimeNumber(i);
			System.out.println(l);
		}
	}

}
