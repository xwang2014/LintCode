package lintcode.greedy;

public class GasStation {
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        
        int index = -1;
        int cur = 0;
        for(int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            cur += diff;
            
            if(index == -1) {
                index = i;
            }
            if(cur < 0) {
                index = -1;
                cur = 0;
            }
        }
        
        if(index != -1) {
	        cur = 0;
	        for(int j = 0; j < gas.length; j++) {
	            int i  = (j + index) % gas.length;
	            cur += gas[i] - cost[i];
	            if(cur < 0) return -1;
	        }
        }
        
        return index;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GasStation so = new GasStation();
		
		int[] gas = {6,0,1,3,2};
		int[] cost = {4,5,2,5,5};
		
		int i = so.canCompleteCircuit(gas, cost);
		
		System.out.println(i);
	}

}
