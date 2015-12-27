package lintcode.dp;

public class DecodeWays {
	
    public int numDecodings(String s) {
        if(s == null || s.length() < 1) return 0;
        
        int[] ways = new int[s.length() + 1];
        ways[0] = 1;
        
        int i = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            if(i == 0) {
                if(c == '0') ways[i + 1] = 0;
                else ways[i + 1] += ways[i];
                i++;
                continue;
            }
            
            char prev = s.charAt(i - 1);
            if(c == '0') {
                if(prev == '1' || prev == '2') {
                    ways[i + 1] += ways[i - 1];
                } else {
                    ways[i + 1] = 0;
                }
            } else {
                if(prev == '1') {
                    ways[i + 1] += ways[i - 1];
                } else if(prev == '2') {
                    if(c > '0' && c <= '6') {
                        ways[i + 1] += ways[i - 1];
                    }
                }
                ways[i + 1] += ways[i];
               
            }
            i++;
        }
        
        return ways[s.length()];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays so = new DecodeWays();
		
		String s = "110";
		int i = so.numDecodings("20");
		System.out.println(i);
	}

}
