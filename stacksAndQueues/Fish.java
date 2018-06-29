// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Stack;

class Solution {
    public int solution(int[] A, int[] B) {
        // sizes --> A
        // directions --> B   0:upstream   1:downstream
        int len = A.length;
        Stack<Integer> upstreamStack = new Stack<>();
        Stack<Integer> downstreamStack = new Stack<>();
        
        for(int i=0; i<len; i++) {
            int size = A[i];
            int direction = B[i];
            
            // downstreaming fish cannot eat previous elements in first pass
            if(direction == 1) { downstreamStack.push(size); }
            
            // upstreaming fish eats all previous downstream smaller fishs
            // .. if meet previous bigger fish, eaten by it
            // .. otherwise saved in upstreamStack
            else {
                while(!downstreamStack.isEmpty() && size > downstreamStack.peek() ) {
                    downstreamStack.pop();
                }
                
                if(downstreamStack.isEmpty()) { upstreamStack.push(size); }
            }
        }
        
        return downstreamStack.size() + upstreamStack.size();
        
    }
}
