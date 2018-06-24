// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {
        // X can fit in memory and O(X) space is allowed - task spec 
        // indicates whether there is leaf at point X
        // frog needs each point to be true 
        // X +1 --> to map each index as real leaf position
        // .. easier for claculations
        boolean[] isLeafFallAtPointArr = new boolean[X+1];
        
        // counts the first leaf at each point 
        // .. since only that is useful to frog
        // .. for frog, there should be exactly X useful leaves
        int usefulLeafCounter = 0;
        
        // looping array, fill isLeafFallAtPointArr to track whether leaf fall at that point
        // doing that keep track of actual set operations (usefulLeafCounter)
        // .. to make sure every point filled (should be X set operations)
        for(int i=0; i<A.length; i++) {
            if(!isLeafFallAtPointArr[A[i]]) {
                isLeafFallAtPointArr[A[i]] = true;
                usefulLeafCounter++;
                
                if(usefulLeafCounter == X) { return i;}
            }
        }
        
        return -1;
    }
}
