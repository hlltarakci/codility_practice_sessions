// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// https://codility.com/media/train/solution-stone-wall.pdf

import java.util.Stack;

class Solution {
    public int solution(int[] H) {
        // Greedy Algorithm: 
        // Build the bottoms as much as common as possible
        // .. for that, keen track of heights in a stack
        // .. while iterating, if current building can be built using stone at top of stack
        // .. than no new stone is needed
        // .. if current building is higher, new stone is needed and top of stack is updated
        // .. if current building is lower, top of stack is popped until we find a <= height stone
        // .. in stack, then new stone is needed for previous ones 
        // .. and current height is pushed to stack
        Stack<Integer> stackOfHeights = new Stack<>();
        int numOfStones = 0;
        
        for(int currentHeight: H) {
            while( !stackOfHeights.isEmpty() && stackOfHeights.peek() > currentHeight) {
                stackOfHeights.pop();
            }
            
            if(!stackOfHeights.isEmpty()) {
                if(stackOfHeights.peek() == currentHeight) { continue; }
                else {
                    numOfStones++;
                    stackOfHeights.push(currentHeight);
                }
            } else {
                numOfStones++;
                stackOfHeights.push(currentHeight);
            }
        }
        
        return numOfStones;
    }
}
