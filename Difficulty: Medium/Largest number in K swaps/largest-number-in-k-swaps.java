//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find the largest number after k swaps.
    public String findMaximumNum(String s, int k) {
        int[] nums = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            nums[i] = s.charAt(i) - '0';
        }
        int i = 0;
        while(k > 0 && i < s.length()){
            for(; i<s.length(); i++){
                int index = i;
                for(int j=s.length() - 1; j>=i+1; j--){
                    if(nums[j] > nums[index]){
                        index = j;
                    }
                }
                if(index != i){
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    k--;
                }
                if(k == 0){
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(int h : nums){
            sb.append(h);
        }
        return sb.toString();
    }
}