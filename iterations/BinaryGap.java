// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int maxGap = 0;
        int countGap = 0;
        boolean counting = false;
        
        while( N > 0 ) {
            if( N % 2 == 1 || N == 1) { 
                counting = true;
                if(maxGap < countGap) { maxGap = countGap; }
                countGap = 0; 
            }
            else if (counting) { countGap++;}
            N /= 2;
        }
        
        return maxGap;
    }
}