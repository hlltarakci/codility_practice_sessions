// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // since looking for smallest positive integer that should exist, but not
        // .. worst case is A contains elements 1...len(A) and answer len(A+1)
        // .. in other cases answer will be smaller that len(A)
        // .. can keep an array to track - since O(n) space is allowed in task spec
        // adopt 1-indexing to map each position to each pos integer value
        // and keep an extra element at the end
        // .. easier for calculations
        boolean[] isIntExist = new boolean[A.length + 2];
        
        populateExistingInts(A, isIntExist);
        
        return findMaxConsecutiveInt(isIntExist) + 1;
    }
    
    private void populateExistingInts(int[] A, boolean[] isIntExist) {
        for(int val: A) {
            if( val <= 0 || val >= A.length + 1 ) { continue; }
            
            if ( !isIntExist[val] ) { isIntExist[val] = true; }
        }
    }
    
    private int findMaxConsecutiveInt(boolean[] isIntExist) {
        // since 1-indexing..
        for(int i=1; i<isIntExist.length; i++) {
            if(!isIntExist[i]) { return i - 1; }
        }
        
        return 0;
    }
}
