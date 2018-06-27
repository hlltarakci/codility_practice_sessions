// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// https://stackoverflow.com/questions/4801242/algorithm-to-calculate-number-of-intersecting-discs/27549852

class Solution {
    public int solution(int[] A) {
        int len = A.length;
        // observation: each center point is between [0 - len) 
        // .. so, checking between this points is enough to observe all circles.
        int[] numOfCirclesStartingArr= new int[len];
        int[] numOfCirclesEndingArr= new int[len];
        
        // check & keep how many circles passes that point for each start and end 
        for(int i=0; i<len; i++) {
            // each point starts at index - radius
            // since there is no need to consider negative points
            // .. keep them at index 
            int starting = i - A[i] < 0 ? 0 : i - A[i];
            numOfCirclesStartingArr[starting]++;
            
            // each point ends at index + radius
            // since there is no need to consider points beyond len
            // .. keep them at index len-1
            // .. long is to eliminate overflow possibility
            int ending = (long)i + (long)A[i] >= len ? len - 1 : i + A[i];
            numOfCirclesEndingArr[ending]++;
        }
        
        // calculate number of intersections using 
        // num of circles starting and ending each point between [0 - len) 
        int numOfIntersects = 0;
        int numOfActiveCircles = 0;
        for(int i=0; i<len; i++) {
            // circles starting at i intersects all active circles
            // .. + all circles at i intersect each other
            numOfIntersects += (numOfCirclesStartingArr[i] * numOfActiveCircles)
                   + (numOfCirclesStartingArr[i]*(numOfCirclesStartingArr[i]-1))/2;
            if (numOfIntersects>10000000) return -1;
            numOfActiveCircles += numOfCirclesStartingArr[i]-numOfCirclesEndingArr[i];
        }
        
        return numOfIntersects;
    }
}
