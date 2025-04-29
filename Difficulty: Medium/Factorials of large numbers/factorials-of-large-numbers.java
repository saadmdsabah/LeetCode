//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    public static ArrayList<Integer> factorial(int n) {
        int[] arr = new int[3000];
        Arrays.fill(arr, -1);
        arr[0] = 1;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=2; i<=n; i++){
            int carry = 0;
            int j = 0;
            for(; j<arr.length; j++){
                if(arr[j] == -1){
                    break;
                }
                int cal = i*arr[j] + carry;
                int first = cal%10;
                carry = cal/10;
                arr[j] = first;
            }
            while(carry > 0){
                arr[j] = carry%10;
                carry = carry/10;
                j++;
            }
        }
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == -1){
                break;
            }
            result.add(arr[i]);
        }
        
        int i = 0;
        int j = result.size() - 1;
        while(i < j){
            int temp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
            i++;
            j--;
        }
        
        return result;
    }
}


//{ Driver Code Starts.

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends