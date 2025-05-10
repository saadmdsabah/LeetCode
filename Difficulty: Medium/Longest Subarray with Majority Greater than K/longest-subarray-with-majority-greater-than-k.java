//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    static int longestSubarray(int[] arr, int k) {
        int[] nums = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            nums[i] = arr[i] > k ? 1 : -1;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        for(int i=0; i<arr.length; i++){
            sum += nums[i];
            if(sum > 0){
                maxLength = Math.max(maxLength, i + 1);
            }
            if(map.containsKey(sum - 1)){
                maxLength = Math.max(maxLength, i - map.get(sum - 1));
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends