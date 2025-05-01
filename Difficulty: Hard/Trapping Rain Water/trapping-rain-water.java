//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int height[]) {
        // code here
        int[] rightMax = new int[height.length];
        int[] leftMax = new int[height.length];

        int right = height[height.length - 1];
        int left = height[0];
        for(int i=0; i<height.length; i++){
            leftMax[i] = left;
            left = Math.max(left, height[i]);
        }
        for(int i=height.length-1; i>=0; i--){
            rightMax[i] = right;
            right = Math.max(right, height[i]);
        }
        int result = 0;
        for(int i=0; i<height.length; i++){
            int curr = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(curr > 0){
                result += curr;
            }
        }
        return result;
    }
}
