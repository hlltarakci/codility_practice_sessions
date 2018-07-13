// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;

class Solution {
    public int solution(int[] A) {
        // Algorithm: find leader in one iteration - O(len)
        // .. use two prefix arrays to keep leader so far - space O(len)
        // .. make to passes - forward and backward and mark if leader is leader so far
        // .. once prefix arrays are ready, check forward prefix array i, backward i+1
        // .. if both leader, i is a split point - count that
        
        int len = A.length;
        boolean[] forwardLeaderCheckArray = new boolean[len];
        boolean[] backwardLeaderCheckArray = new boolean[len];

        int leader = computeLeader(A);
        
        // forward pass
        int countSoFar = 0;
        for(int i=0; i<len; i++) {
            if(A[i] == leader ) { countSoFar++; }
            if( (double)countSoFar / (i+1) > 0.5 ) { forwardLeaderCheckArray[i] = true; }
        }
        
        // backward pass
        countSoFar = 0;
        for(int i=len-1; i>=0; i--) {
            if(A[i] == leader ) { countSoFar++; }
            if( (double)countSoFar / (len-i) > 0.5 ) { backwardLeaderCheckArray[i] = true; }
        }
        
        // evaluate
        int numOfSplits = 0;
        for(int i=1; i<len; i++) {
            if(forwardLeaderCheckArray[i-1] && backwardLeaderCheckArray[i]) { numOfSplits++; }
        }

        return numOfSplits;
    }
    
    // majority vote algorithm
    private int computeLeader(int A[]) {
        // init to first, since we know at least there is one element - task spec
        int leader = A[0];
        int counter = 1;
        
        for(int i=1; i<A.length; i++) {
            if(A[i] == leader) { counter++; }
            else {
                counter--;
                if(counter == 0) { 
                    leader = A[i];
                    counter++;
                }
            }
        }
        
        return leader;
    }
}
