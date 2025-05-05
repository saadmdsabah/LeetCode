//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    
    class Pair{
        int start;
        int end;
        public Pair(int s, int e){
            this.start = s;
            this.end = e;
        }
    }
    
    public int maxMeetings(int start[], int end[]) {
        Pair[] pair = new Pair[start.length];
        for(int i=0; i<start.length; i++){
            pair[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(pair, (a, b)->Integer.compare(a.end, b.end));
        
        int result = 0;
        int endTime = -1;
        
        for(int i=0; i<start.length; i++){
            if(pair[i].start > endTime){
                result++;
                endTime = pair[i].end;
            }
        }
        return result;
    }
}
