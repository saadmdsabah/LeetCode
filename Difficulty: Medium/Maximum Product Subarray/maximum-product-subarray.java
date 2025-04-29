//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        int prefix = 1;
        int suffix = 1;
        int n = arr.length;
        int max = Integer.MIN_VALUE;
    
        for (int i = 0; i < n; i++) {
            prefix = (prefix == 0 ? 1 : prefix) * arr[i];
            suffix = (suffix == 0 ? 1 : suffix) * arr[n - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
            if (arr[i] == 0) prefix = 1;
            if (arr[n - i - 1] == 0) suffix = 1;
        }
        return max;
    }

}