//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.minSwap(a, k);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    int minSwap(int[] arr, int k) {
        int count = 0;
        for(int i : arr){
            if(i <= k){
                count++;
            }
        }
        
        int swaps = 0;
        int minSwaps = Integer.MAX_VALUE;
        
        for(int i=0; i<count; i++){
            if(arr[i] > k){
                swaps++;
            }
        }
        minSwaps = Math.min(minSwaps, swaps);
        
        for(int i=count; i<arr.length; i++){
            if(arr[i - count] > k){
                swaps--;
            }
            if(arr[i] > k){
                swaps++;
            }
            minSwaps = Math.min(minSwaps, swaps);
        }
        
        return minSwaps;
    }
}
