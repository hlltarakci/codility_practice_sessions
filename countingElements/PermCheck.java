// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // a permutation should have all from 1 to len(A) 
        // .. O(n) space is allowed in task space
        int len = A.length;
        // 1-indexing to match entries with integers
        // .. for easy calculation 
        boolean[] isIntExist = new boolean[len+1];
        
        for(int val: A) {
            if(val > len || isIntExist[val]) return 0;
            isIntExist[val] = true;
        }
        
        return checkForPermutation(isIntExist);
    }
    
    private int checkForPermutation(boolean[] isIntExist) {
        // since 1-indexing, skip 0th index
        for(int i=1; i<isIntExist.length; i++) {
            if(!isIntExist[i]) return 0;
        }
        
        return 1;
    }
}
