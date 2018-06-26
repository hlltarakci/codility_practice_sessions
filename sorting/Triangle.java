// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        // sort array
        // linearly check for triangle property
        
        Arrays.sort(A);
        
        for(int i=0; i<A.length - 2;i++) {
            if(checkForTriangleProperty(A, i)) { return 1; }
        }
        
        return 0;
    }
    
    private boolean checkForTriangleProperty(int[] A, int startIndex) {
        if( calcSum(A[startIndex], A[startIndex+1]) > A[startIndex+2] &&
            calcSum(A[startIndex+2], A[startIndex]) > A[startIndex+1] &&
            calcSum(A[startIndex+1], A[startIndex+2]) > A[startIndex] ) { return true; }
            
        return false;
    }
    
    // when max int is possible, 
    // ..sum should handle in long - since it cannot fit and overflow
    private long calcSum(int a, int b) {
        return (new Long(a) + new Long(b));
    }
}
