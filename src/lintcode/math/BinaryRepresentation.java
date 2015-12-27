package lintcode.math;

public class BinaryRepresentation {
	
    public String binaryRepresentation(String n) {
        // write your code here
        if(n == null ) return "0";
        
        String inte = n.split("\\.")[0];
        String decimal = null;
        if(n.contains(".")) {
            decimal = n.split("\\.")[1];
        }
        
        
        String second = processDec(decimal);
        if(second == null) return "ERROR";
        
        String first = processInte(inte);
        if(first == null) return "ERROR";
        
        if(second.isEmpty() || second.equals("0") ) {
        	return first;
        } else {
        	return first + "." + second;
        }
        
    }
    
    private String processDec(String dec) {
    	String ans = "";
    	
    	Double d = Double.parseDouble("." + dec);
    	
    	int i = 0;
    	
    	while(i++ < 32) {
    		d = d * 2;
    		if(d >= 1) {
    			ans = ans + "1";
    			d = d - 1;
    		} else {
    			ans = ans + "0";
    		}
    		if(ans.length() >= 32) {
    			return null;
    		}
    		if(Double.compare(0, d) == 0) {
    			break;
    		}
    	}
    	
    	return ans;
    }
    
    private String processInte(String str) {
    	if(str == null || str.isEmpty()) return "0";
    	
    	String ans = "";
    	
    	Long d = Long.parseLong(str);
    	
    	if(d == 0) return "0";
    	
    	while(d > 0) {
    		ans = d % 2 + ans;
    		d = d / 2;
    		
    		if(ans.length() >= 32) return null;
    	}
    	
    	return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryRepresentation so = new BinaryRepresentation();
		
		String[] nums = { //"3.5", "3.75", "3.72", ".5", 
				"17817287.6418609619140625" };
		
		for(String n : nums) {
			String bi = so.binaryRepresentation(n);
			
			System.out.println(bi);
		}
	}

}
