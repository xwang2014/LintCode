package lintcode.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FractiontoRecurringDecimal {
	
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return null;
        if(numerator == 0) return "0";
        // + - 
        boolean positive = true;
        long a = numerator, b = denominator;
        if(numerator < 0) {
        	positive = !positive;
        	a = -(long)a;
        }
        if(denominator < 0) {
        	positive = !positive;
        	b = -(long)b;
        }
        
        HashMap<Long, Integer> frac = new HashMap<Long, Integer>();
        
        // Process integer part
        long intPart = a / b;
        long n = a % b;
        
        List<String> digits = new ArrayList<String>();
        int i = 0;
        while(n != 0) {
            if(frac.containsKey(n) ) {
                digits.add(")");
                digits.add(frac.get(n), "(");
                break;
            } else {
                frac.put(n, i);
                
            }
        	
            n = n * 10;
            
            long d = n / b;
            digits.add("" + d);
            n = n % b;
            
            i++;
        }
        
        StringBuffer sb = new StringBuffer();
        sb.append("" + intPart);
        if(digits.size() > 0) {
        	sb.append(".");
            for(String d : digits) {
                sb.append(d);
            }
        }

        
        if(positive) {
        	return sb.toString();
        } else {
        	return "-" + sb.toString();
        }
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FractiontoRecurringDecimal so = new FractiontoRecurringDecimal();
		
		String ans = so.fractionToDecimal(-2147483648, 1);
		System.out.println(ans);
	}

}
