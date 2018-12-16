// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        int maxGap = 0, currGap = 0;
        boolean isInGap = false;
        
        while(N > 0) {
            if(isOne(N)) {
                maxGap = maxGap < currGap ? currGap : maxGap;
                currGap = 0;
                isInGap = true;
            } else if(isInGap){ currGap++; }
            N /= 2;
        }
        
        return maxGap;
    }
    
    private boolean isOne(int N) {
        return N%2 == 1 || N == 1 ;
    }
}
