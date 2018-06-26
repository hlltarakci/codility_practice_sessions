// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        // sort array
        // max triple product could be:
        // .. max 3 elements (indexes n-1, n-2, n-3)
        // .. max 1 element and max negative 2 elements (indexes 0, 1, n-3)

        Arrays.sort(A);

        //at least 3 elements guarateed - task spec
        int len = A.length;
        
        return Math.max(A[len-1]*A[len-2]*A[len-3] , 
                        A[len-1]*A[0]*A[1]);
    }
}
