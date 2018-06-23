// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // cumulative approach works - two passes
        // first pass (left to right): at each point we can store left sum for that point 
        // .. no additional space is required, we can update array A
        // .. since an element is equal to its diff with its left element (calculatable)
        // second point (right to left): at each point we can calculate right sum (no need to store)
        // .. and since both left and right sums known at second pass, take diff and search for min
        
        // first pass
        calculateLeftSums(A);
        
        // second pass 
        return findMinDiffPoint(A);
        
    }
    
    private void calculateLeftSums(int[] A) {
        // sure A has at least 2 elements from task spec
        for(int i=1; i<A.length; i++) {
            A[i] += A[i-1];
        }
    }
    
    private int findMinDiffPoint(int[] A) {
        int minDiff = Integer.MAX_VALUE;
        int rightSum = 0;
        for(int i=A.length -1; i > 0; i--) {
            rightSum += A[i] - A[i-1];
            int diff = Math.abs( rightSum - A[i-1] );
            if( diff < minDiff ) {minDiff = diff;}
        }
        
        return minDiff;
    }
}
