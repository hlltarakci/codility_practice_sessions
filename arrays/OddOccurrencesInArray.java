// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // sure there is at least one element
        int result = A[0]; 
        
        // bitwise xor wipes out double elements
        // only remains odd values
        // loop for remaining
        for(int i=1; i<A.length; i++) {
            result ^= A[i];
        }
        
        return result;
    }
}
