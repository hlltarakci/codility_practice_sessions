// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // slices can only be 2 or 3 in length (mathematically)
        // .. prefix sum at starting index - avg with next item
        // .. can be dome in space
        
        double minAvg = Double.MAX_VALUE;
        int minAvgIndex = 0;
        
        for(int i=0; i<A.length-1; i++) {
            double avg = (A[i] + A[i+1]) / 2.0;
            if(i < A.length - 2) {
                double avgOf3 = (A[i] + A[i+1] + A[i+2]) / 3.0;
                avg = avgOf3 < avg ? avgOf3 : avg;
            }
            
            if(minAvg > avg) { 
                minAvg = avg;
                minAvgIndex = i;
            }
        }
        
        return minAvgIndex;
    }
}
