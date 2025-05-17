//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    
    class Pair{
        int x;
        int y;
        int val;
        public Pair(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc, image[sr][sc]));
        visited[sr][sc] = true;
        image[sr][sc] = color;

        while(!q.isEmpty()){
            Pair currPair = q.remove();
            int x = currPair.x;
            int y = currPair.y;
            int val  = currPair.val;

            int[] xd = {-1,1,0,0};
            int[] yd = {0,0,-1,1};
            for(int i=0; i<4; i++){
                int newX = x + xd[i];
                int newY = y + yd[i];
                if(newX >= 0 && newX < n && newY >=0 && newY < m && image[newX][newY] == val && !visited[newX][newY]){
                    image[newX][newY] = color;
                    q.add(new Pair(newX, newY, val));
                    visited[newX][newY] = true;
                }
            }
        }
        return image;
    }
}