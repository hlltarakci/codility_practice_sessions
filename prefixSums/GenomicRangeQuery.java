// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        // ACGT 1234 
        // prefix sums for A C G 
        // .. no need for T, since it is default case if others are 0
        
        int len = S.length();
        // 1-indexing for easy calculations
        int[] prefixA = new int[len+1];
        int[] prefixC = new int[len+1];
        int[] prefixG = new int[len+1];
        
        populatePrefixArr(S, prefixA, prefixC, prefixG);
        
        return calculateMinImpact(P, Q, prefixA, prefixC, prefixG);
    }
    
    private void populatePrefixArr(String S, int[] prefixA, int[] prefixC, int[] prefixG) {
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            
            if(c == 'A') { prefixA[i+1]++; }
            else if(c == 'C') { prefixC[i+1]++; }
            else if(c == 'G') { prefixG[i+1]++; }
            
            prefixA[i+1] += prefixA[i];
            prefixC[i+1] += prefixC[i];
            prefixG[i+1] += prefixG[i];
            
        }
    }
    
    private int[] calculateMinImpact(int[] P, int[] Q, int[] prefixA, int[] prefixC, int[] prefixG) {
        int[] minImpactArr = new int[P.length];
        
        for(int i=0; i<P.length; i++) {
           int start = P[i];
           // +1 since q is inclusive
           int end = Q[i] + 1;
           
           if(prefixA[end] - prefixA[start] > 0) { minImpactArr[i] = 1; }
           else if(prefixC[end] - prefixC[start] > 0) { minImpactArr[i] = 2; }
           else if(prefixG[end] - prefixG[start] > 0) { minImpactArr[i] = 3; }
           else { minImpactArr[i] = 4; }
        }

        return minImpactArr;
    }
    
}
