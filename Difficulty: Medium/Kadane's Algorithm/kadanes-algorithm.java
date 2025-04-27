//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    int maxSubarraySum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        
        for(int i=0; i<arr.length; i++){
            currentSum += arr[i];
            if(currentSum > max){
                max = currentSum;
            }
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return max;
    }
}
