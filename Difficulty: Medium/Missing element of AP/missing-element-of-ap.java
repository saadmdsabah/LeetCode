//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        Solution solution = new Solution();
        while (t-- > 0) {
            String input = reader.readLine().trim();
            String[] parts = input.split("\\s+");
            int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

            System.out.println(solution.findMissing(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMissing(int[] arr) {
        int n = arr.length;
    
        int d1 = arr[1] - arr[0];
        int d2 = arr[2] - arr[1];
        int d3 = arr[n - 1] - arr[n - 2];
        int d = (d1 == d2) ? d1 : (d2 == d3 ? d2 : d1); 
    
        int low = 0, high = n - 1;
    
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int expected = arr[0] + mid * d;
    
            if (arr[mid] == expected) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    
        return arr[0] + low * d;
    }

}
