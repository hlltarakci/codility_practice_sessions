// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Stack;

class Solution {
    public int solution(int[] A) {
        // majority vote algorithm
        int candidateIndex = -1;
        int counter = 0;
        
        for(int i=0; i<A.length; i++) {
            // first element, init
            if(candidateIndex < 0) {
                candidateIndex = 0;
                counter++;
                continue;
            }
            
            // same element, increment counter
            if(A[i] == A[candidateIndex]) { counter++; }
            
            // different element
            // .. decrement counter if possible
            // .. otherwise set current index as candidate
            else {
                if( counter > 0) { counter--; }
                else {
                    counter = 0;
                    candidateIndex = i;
                }
            }
        }
        
        return (isDominator(A, candidateIndex)) ? candidateIndex : -1;
    }
    
    private boolean isDominator(int[] A, int candidateIndex) {
        if(candidateIndex < 0) return false;
        
        int countOfCandidate = 0;
        
        for(int element: A) {
            if(element == A[candidateIndex]) { countOfCandidate++; }
        }
        
        return (countOfCandidate > A.length/2) ? true : false;
    }
}
