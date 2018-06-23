// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // since all distinct, we are safe.. some controls can be omitted
        // if the missing also available, sum would be n (n + 1) / 2 where n = length (A) + 1
        // tip: sums should be long, since might overflow for large n
        long shouldBeLength = A.length + 1;
        long shouldBeSum = shouldBeLength * (shouldBeLength + 1) / 2;
        
        return (int) (shouldBeSum - calcSum(A));
        
    }
    
    private long calcSum(int[] A) {
        long sum = 0;
        
        for(int elem: A) { sum += elem; }
        
        return sum;
    }
}
