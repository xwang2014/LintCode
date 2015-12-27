package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if(words == null || words.length < 1) return res;
        
        int startPt = 0;
        int len = 0;
        
        while(true) {
            int pt = startPt;
            len += words[pt].length();
            
            while(pt < words.length - 1 &&
                len + words[pt + 1].length() + (pt + 1 - startPt) <= maxWidth ) {
                
            	len += words[pt + 1].length();
                pt++;
            }
            
            if(pt < words.length - 1) {
                String ans = getLine(words, maxWidth, startPt, pt);
                res.add(ans);
            } else if(pt == words.length - 1) {
                String ans = getLastLine(words, maxWidth, startPt, pt);
                res.add(ans);
            }
            
            if(pt == words.length - 1) break;
            
            startPt = pt + 1;
            len = 0;
        }
        
        return res;
    }
    
    private String getLastLine(String[] words, int maxWidth, int start, int end) {
        StringBuffer sb = new StringBuffer();
        
        for(int i = start; i <= end; i++) {
            sb.append(words[i]);
            
            if(i < end) {
                sb.append(" ");
            }
        }
        
        while(sb.length() < maxWidth) {
        	sb.append(" ");
        }
        
        return sb.toString();
    }
    
    private String getLine(String[] words, int maxWidth, int start, int end ) {
        StringBuffer sb = new StringBuffer();
        
        int charLen = 0;
        for(int i = start; i <= end; i++) {
            charLen += words[i].length();
        }
        
        int space = (maxWidth - charLen);
        if(end > start) space = (maxWidth - charLen) / (end - start);
        
        int extraSpace = 0;
        if(end > start) extraSpace = (maxWidth - charLen) % (end - start);
        
        
        for(int i = start; i <= end; i++) {
            sb.append(words[i]);
            
            if(i < end) {
	            for(int j = 0; j < space; j++) 
	                sb.append(" ");
	
	            if(i - start < extraSpace) {
	                sb.append(" ");
	            }
            }
        }
        
        while(sb.length() < maxWidth) {
        	sb.append(" ");
        }
        
        return sb.toString();
    }	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextJustification so = new TextJustification();
		
		//String[] words = {"This", "is", "an", "example", "of", "text", "justification." };
		// 16
		
		String[] words = {"Here","is","an","example","of","text","justification." }; // 12
		
		List<String> ans = so.fullJustify(words, 14);
		
		System.out.println(ans);
	}

}
