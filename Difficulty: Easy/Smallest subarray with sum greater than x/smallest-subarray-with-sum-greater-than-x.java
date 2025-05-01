//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T > 0) {
            int x = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            System.out.println(solution.smallestSubWithSum(x, arr));

            T--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    public static int smallestSubWithSum(int x, int[] arr) {
        int startingIndex = 0;
        int endingIndex = Integer.MAX_VALUE - 1;
        
        int i = 0;
        int j = 0;
        int sum = 0;
        while(j < arr.length){
            sum += arr[j];
            while(i <= j && sum - arr[i] > x){
                sum -= arr[i];
                i++;
            }
            if(sum > x){
                if(j - i + 1 < endingIndex - startingIndex + 1){
                    startingIndex = i;
                    endingIndex = j;   
                }
            }
            j++;
        }
        if(endingIndex == Integer.MAX_VALUE - 1){
            return 0;
        }
        return endingIndex - startingIndex + 1;
    }
}
