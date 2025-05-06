//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            int ans = obj.minCandy(arr);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minCandy(int ratings[]) {
        // code here
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        for(int i=0; i<ratings.length; i++){
            if(i - 1 >= 0){
                if(ratings[i] > ratings[i-1]){
                    left[i] = left[i-1] + 1;
                }else{
                    left[i] = 1;
                }
            }else{
                left[i] = 1;
            }
        }

        for(int i=ratings.length-1; i>=0; i--){
            if(i + 1 < ratings.length){
                if(ratings[i] > ratings[i+1]){
                    right[i] = right[i+1] + 1;
                }else{
                    right[i] = 1;
                }
            }else{
                right[i] = 1;
            }
        }
        int result = 0;
        for(int i=0; i<ratings.length; i++){
            result += Math.max(left[i], right[i]);
        }
        return result;
    }
}
