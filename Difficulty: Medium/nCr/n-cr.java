//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int r = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public int powerExponentiation(long x, int n){
        if(n == 0){
            return 1;
        }
        if(x == 0){
            return 0;
        }
        if(x == 1){
            return 1;
        }
        int mod = 1000000007;
        long result = 1;
        while(n > 0){
            if(n%2 == 1){
                result = (result * x)%mod;
            }
            x = (x*x)%mod;
            n = n/2;
        }
        return (int) result;
    }
    
    public int nCr(int n, int r) {
        if(r > n){
            return 0;
        }
        int mod = (int) 1e9 + 7;
        long[] factorial = new long[101];
        factorial[0] = 1;
        for (int i = 1; i < 101; i++) {
            factorial[i] = (factorial[i - 1] * i) % mod;
        }

        
        int[] inverseFactorial = new int[101];
        for(int i=0; i<101; i++){
            inverseFactorial[i] = powerExponentiation((long) factorial[i], mod - 2);
        }
        
        long result = (factorial[n] * inverseFactorial[r]) % mod;
        result = (result * inverseFactorial[n - r]) % mod;
        return (int) result;
    }
}