// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] A) {
        int[] counterArr = new int[N];
        // tracking max so far
        int maxSoFar = 0;
        // tracking max so far that is actually set
        int actualMaxSoFar = 0;
        
        for(int val: A) {
            // handleIncreaseX
            if(val <= N) {
                // handling actualMaxSoFar inline
                if( counterArr[val-1] < actualMaxSoFar ) { counterArr[val-1] = actualMaxSoFar; }
                if( ++counterArr[val-1] > maxSoFar) { maxSoFar = counterArr[val-1]; }
            }
            
            // handleMaxCounter
            else { 
                // do not need to fill counter array actually
                // Arrays.fill(counterArr, maxSoFar); 
                actualMaxSoFar = maxSoFar;
            }
        }
        
        patch4ActualMaxSoFar(counterArr, actualMaxSoFar);
        
        return counterArr;
    }
    
    private void patch4ActualMaxSoFar(int[] counterArr, int actualMaxSoFar) {
        for(int i=0; i<counterArr.length; i++) {
            if(counterArr[i] < actualMaxSoFar) { counterArr[i] = actualMaxSoFar;}
        }
    }
    
}
