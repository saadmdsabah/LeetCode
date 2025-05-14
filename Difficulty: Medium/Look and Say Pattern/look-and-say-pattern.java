//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            System.out.println(ob.countAndSay(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder("1");
        for(int i=1; i<n; i++){
            StringBuilder temp = new StringBuilder("");
            for(int j=0; j<s.length(); j++){
                int count = 0;
                int k = j;
                boolean taken = false;
                while(k < s.length() && s.charAt(k) == s.charAt(j)){
                    count++;
                    k++;
                    taken = true;
                }
                temp.append(String.valueOf(count) + s.charAt(j));
                if(taken){
                    j = k - 1;
                }
            }
            s = new StringBuilder(temp);
        }
        return s.toString();
    }
}
