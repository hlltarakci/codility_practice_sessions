// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Stack;

class Solution {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        
        for(Character c: S.toCharArray()) {
            if(c == '(') { stack.push(c); }
            else {
                if( stack.isEmpty() ) { return 0; }
                stack.pop();
            }
        }
        
        if(stack.isEmpty()) { return 1; }
        
        return 0;
    }
}
