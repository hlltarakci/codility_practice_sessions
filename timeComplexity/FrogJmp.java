// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int Y, int D) {

     int initialJumpCount = (Y-X) / D;
     int remainingJumpCount = (Y-X) % D;
     
     return 
        (remainingJumpCount > 0 ? initialJumpCount + 1: initialJumpCount);

    }
}
