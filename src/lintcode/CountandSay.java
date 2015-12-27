package lintcode;

public class CountandSay {
	
    public String countAndSay(int n) {
        if(n <= 0) return "";
        
        String orig = "1";
        
        for(int i = 0; i < n - 1; i++) {
            orig = helper(orig);
            System.out.println(orig);
        }
        
        return orig;
    }
    
    private String helper(String s) {
        StringBuffer sb = new StringBuffer();
        
        char c = s.charAt(0);
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(i == 0) {
                c = cur;
                num = 1;
                continue;
            }
            
            if(cur != c) {
                sb.append("" + num + (c - '0'));
                c = cur;
                num = 1;
            } else {
                num++;
            }
        }
        sb.append("" + num + (c - '0') );
        
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountandSay so = new CountandSay();
		
		so.countAndSay(25);
	}

}
