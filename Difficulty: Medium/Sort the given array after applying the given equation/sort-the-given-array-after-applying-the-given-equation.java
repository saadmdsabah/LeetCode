//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read the array line and convert to int[]
            String input = br.readLine().trim();
            String[] tokens = input.split("\\s+");
            int n = tokens.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Read a, b, c from separate lines
            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());
            int c = Integer.parseInt(br.readLine().trim());

            // Call the solution method
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.sortArray(arr, a, b, c);

            // Output the result
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
    // int n = arr.length;
    // int[] result = new int[n];

    // int left = 0;
    // int right = n - 1;
    // int index = A >= 0 ? n - 1 : 0;

    // while (left <= right) {
    //     int valLeft = A * arr[left] * arr[left] + B * arr[left] + C;
    //     int valRight = A * arr[right] * arr[right] + B * arr[right] + C;

    //     if (A >= 0) {
    //         if (valLeft > valRight) {
    //             result[index--] = valLeft;
    //             left++;
    //         } else {
    //             result[index--] = valRight;
    //             right--;
    //         }
    //     } else {
    //         if (valLeft < valRight) {
    //             result[index++] = valLeft;
    //             left++;
    //         } else {
    //             result[index++] = valRight;
    //             right--;
    //         }
    //     }
    // }

    // Convert result[] to ArrayList<Integer> efficiently
    ArrayList<Integer> resList = new ArrayList<>();
    
    for(int i=0; i<arr.length; i++){
        int val = A * arr[i] * arr[i] + B * arr[i] + C;
        resList.add(val);
    }
    
    Collections.sort(resList);
    return resList;
}

}