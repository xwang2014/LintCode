package lintcode.sort;


class NBComparator {
	public int cmp(String a, String b) {
		return a.charAt(a.length() - 1) - b.charAt(b.length() - 1);
	}
}

public class NutsBoltsProblem {
	

	
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if(nuts == null || bolts == null || nuts.length <= 1 
            || bolts.length <= 1) {
                return;
            }
        
        nbsort(nuts, bolts, compare, 0, nuts.length - 1);
    }
    
    private void nbsort(String[] nuts, String[] bolts, NBComparator compare,
        int start, int end) {
        if(start >= end) return;
        
        int part = partition(nuts, bolts, compare, start, end);
        if(part - 1 > start) {
            nbsort(nuts, bolts, compare, start, part - 1);
        }
        if(part + 1 < end) {
            nbsort(nuts, bolts, compare, part + 1, end);
        }
        
    }
    
    private int partition(String[] nuts, String[] bolts, NBComparator compare,
        int start, int end) {
        
        int pivot = start + (end - start) / 2;
        
        // use nuts to sort bolts
        String nut = nuts[pivot];
        int storeIndex = start, i = start;
        while(i < end) {
            if(compare.cmp(nut, bolts[i]) > 0) {
                String temp = bolts[i];
                bolts[i] = bolts[storeIndex];
                bolts[storeIndex] = temp;
                
                storeIndex++;
            } else if(compare.cmp(nut, bolts[i]) == 0) {
                String temp = bolts[end];
                bolts[end] = bolts[i];
                bolts[i] = temp;
                
                continue;
            }
            
            i++;
        }
        
        String temp = bolts[storeIndex];
        bolts[storeIndex] = bolts[end];
        bolts[end] = temp;
        
        // use bolts to sort nuts
        String bolt = bolts[storeIndex];
        int markIndex = start;
        i = start;
        while(i < end) {
            if(compare.cmp(nuts[i], bolt) < 0) {
                temp = nuts[i];
                nuts[i] = nuts[markIndex];
                nuts[markIndex] = temp;
                
                markIndex++;
            } else if(compare.cmp(nuts[i], bolt) == 0) {
                temp = nuts[end];
                nuts[end] = nuts[i];
                nuts[i] = temp;
                continue;
            }
            
            i++;
        }
        
        temp = nuts[end];
        nuts[end] = nuts[markIndex];
        nuts[markIndex] = temp;
        
        //System.out.println("Store=" + storeIndex + "   mark=" + markIndex);
        
        return markIndex;
    }

	public static void main(String[] args) {
		// 
		NutsBoltsProblem so = new NutsBoltsProblem();
		NBComparator nb = new NBComparator();
		
		String[] nuts = {"ab","aa","ac", "az" };
		String[] bolts = {"a", "c","z", "b" }; 
		
		so.sortNutsAndBolts(nuts, bolts, nb);
		
		for(String n : nuts) {
			System.out.print(n + "  ");
		}
		System.out.println();
		
		for(String n : bolts) {
			System.out.print(n + "  ");
		}
	}

}
