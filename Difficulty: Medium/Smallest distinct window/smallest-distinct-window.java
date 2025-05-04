//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public boolean isValid(int[] map, int[] present){
        for(int i=0; i<26; i++){
            if(present[i] == 1 && map[i] == 0){
                return false;
            }
        }
        return true;
    }
    
    public int findSubString(String s) {
        int[] present = new int[26];
        int[] map = new int[26];
        for(int i=0; i<s.length(); i++){
            present[s.charAt(i) - 'a'] = 1;
        }
        
        int i = 0;
        int j = 0;
        int result = Integer.MAX_VALUE;
        
        while(j < s.length()){
            map[s.charAt(j) - 'a']++;
            while(isValid(map, present) && i <= j){
                if((j - i + 1) < result){
                    result = j - i + 1;
                }
                map[s.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }
        return result;
    }
}