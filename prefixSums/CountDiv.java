// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int A, int B, int K) {
        int upToADivByK = (A==0 ? 0 : (A-1) / K);
        int upToBDivByK = B / K;
        
        return (A == 0 ? ((upToBDivByK - upToADivByK) + 1) : (upToBDivByK - upToADivByK)) ;
    }
}
