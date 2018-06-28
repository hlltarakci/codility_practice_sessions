// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Stack;

class Solution {
    public int solution(String S) {
        String openBrackets = "{[(";
        String closeBrackets = "}])";
        
        Stack<Character> stack = new Stack<>();
        
        for(char c: S.toCharArray()) {
            if(isInBrackets(c, openBrackets)) { stack.push(c); }
            else {
                if(stack.isEmpty() ||
                    stack.pop() != getCorrespondingOpenBracket(c, openBrackets, closeBrackets)) 
                    { return 0; }
            }
        }
        
        if(stack.isEmpty()) return 1;
        return 0;
    }
    
    private boolean isInBrackets(char c, String brackets) {
        if(brackets.indexOf(c) >= 0) { return true; }
        return false;
    }
    
    private char getCorrespondingOpenBracket(char closeBracket, String openBrackets, String closeBrackets) {
        return openBrackets.charAt(closeBrackets.indexOf(closeBracket));
    }
}
