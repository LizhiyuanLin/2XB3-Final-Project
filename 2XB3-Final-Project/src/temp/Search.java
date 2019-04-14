package temp;

import java.util.Arrays;
import java.util.ArrayList;

public class Search {

    public Search() { }

    public static int indexOf(Industry[] a, Double key) {
        int lo = 0;
        int hi = a.length - 1;
        //System.out.println(hi);
        int mid = 0;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            mid = lo + (hi - lo) / 2;
            //System.out.println(mid);
            if      (key > a[mid].HourlyEarn()) hi = mid - 1;
            else if (key < a[mid].HourlyEarn()) lo = mid + 1;
            else return mid;
        }
        //System.out.println("B");
        //System.out.println(mid);
        return mid;
    }
    
    public static Industry[] printout(Industry[] a, Double wantedWage) {
    	Industry output[] = new Industry[0];//output array
    	ArrayList<Industry> aboveAndunder = new ArrayList<Industry>(Arrays.asList(output));
    	int highestInd = 0;
    	if (a == null) return null;
    	if (wantedWage <= 0.0) {
    		for (int i = a.length-1; i >= 0; i--) {
    			if (a[i].HourlyEarn() > 0.0) {
    				highestInd = i;
    				break;
    			}
    		}
    		for (int i = highestInd - 9; i <= highestInd && i >= 0; i++){
    			aboveAndunder.add(a[i]);
    		}
    	}
    	else {
    		int j = indexOf(a, wantedWage);//value of mid
    		//System.out.println(j);
    		for (int i = j-5; i < j ; i++) {
    			if (i > 0) { 
    				if (a[i].HourlyEarn() > 0.0) {
        				aboveAndunder.add(a[i]);
    				}
    			}
    			else continue; 
    			
    		}
    	
    		for (int i = j; (i < j+5) && (a[i].HourlyEarn() > 0.0); i++) {
    			aboveAndunder.add(a[i]);
    		}
    	}
    	output = aboveAndunder.toArray(output);
    	
    	return output;
    }
}
