//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    
    public void dfs(char[][] grid, int x, int y, boolean[][] visited){
        if(visited[x][y]){
            return;
        }
        visited[x][y] = true;
        int[] xd = {-1, 1, 0, 0, 1, -1, -1, 1};
        int[] yd = {0, 0, -1, 1, -1, 1, -1, 1};
        for(int i=0; i<8; i++){
            if(x + xd[i] >= 0 && x + xd[i] < grid.length && y + yd[i] >= 0 && y + yd[i] < grid[0].length && !visited[x+xd[i]][y+yd[i]] && grid[x+xd[i]][y+yd[i]] == 'L'){
                dfs(grid, x+xd[i], y+yd[i], visited);
            }
        }
    }
    
    public int countIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 'L'){
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }
}