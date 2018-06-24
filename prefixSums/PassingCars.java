// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // 0: east -->
        // 1: west <--
        // p: -->
        // q:   <--   passing
        // for each left 0, there are as many passing cars as 1 s on its right
        // in other words,
        // ... for each 1, there are as many passing cars as 0 s on its left
   
        int eastCount = 0;
        int passingCount = 0;
        
        for(int val: A) {
            if(val == 0) { eastCount++; }
            else { passingCount += eastCount; }
            
            if(passingCount > 1000000000) return -1;
        }
        
        return passingCount;
    }
}
