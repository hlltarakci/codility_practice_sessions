// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int K) {
        int len = A.length;
        if(len == 0) { return A; }
        
        K %= len;
        if(K == 0) { return A; }
        
        rotate(A, K);
        
        return A;
    }
    
    private void rotate(int[]A, int K) {
        int len = A.length;
        
        int bucket = gcd(len, K);
    
        // ...I are index variables, ..E are element/value variables
        // there are as many buckets/groups as gcd
        // algorithm should loop for each bucket
        // current element is kept
        // jump to K elements forward (might be cyclic, use modular arithmetic)
        // put kept element in here and keep element that is already there (need a swap variable)
        // continue with jumping K elements forward, until you are at where you started
        // do this for each bucket
        for(int i=0; i<bucket; i++) {
            int currentI = i;
            int jumpI = i + K;
            int keepE = getElem(A, i);
            do{
                int swapE = keepE;
                keepE = getElem(A, jumpI);
                setElem(A, jumpI, swapE);
                currentI = jumpI;
                jumpI = currentI + K;
            } while(currentI%len != i);
            
        }
    }
    
    private int gcd(int a, int b) {
        if( b == 0) { return a; }
        
        return gcd(b, a%b);
    }
    
    private int getElem(int[] A, int i) {
        return A[i%A.length];
    }
    
    private void setElem(int[] A, int i, int val) {
        A[i%A.length] = val;
    }
}
