//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[][] intervals = IntMatrix.input(br, n, 2);
            
            Solution obj = new Solution();
            int res = obj.overlap(n, intervals);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int overlap(int n, int[][] intervals) {
        int[] starting = new int[intervals.length];
        int[] ending = new int[intervals.length];
        
        int max = 0;
        for(int i=0; i<intervals.length; i++){
            starting[i] = intervals[i][0];
            ending[i] = intervals[i][1];
            max = Math.max(intervals[i][1], max);
        }
        
        Arrays.sort(starting);
        Arrays.sort(ending);
        int[] prefix = new int[max + 2];
        
        for(int i=0; i<ending.length; i++){
            prefix[starting[i]]++;
            prefix[ending[i] + 1]--;
        }
        
        int result = 0;
        for(int i=1; i<prefix.length; i++){
            prefix[i] += prefix[i-1];
            result = Math.max(result, prefix[i]);
        }
        return result;
    }
}
