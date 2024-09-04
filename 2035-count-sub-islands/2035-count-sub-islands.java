class Solution {

    public boolean bfs(int i, int j, int[][] grid1, int[][] grid2, int n, int m, boolean[][] vis){
        if(i < 0 || j < 0 || i >= n || j >= m || grid2[i][j] == 0 || vis[i][j]){
            return true;
        }
        if(grid1[i][j] != grid2[i][j]){
            return false;
        }
        vis[i][j] = true;
        boolean left = bfs(i, j-1, grid1, grid2, n, m, vis);
        boolean right = bfs(i, j+1, grid1, grid2, n, m, vis);
        boolean up = bfs(i-1, j, grid1, grid2, n, m, vis);
        boolean down = bfs(i+1, j, grid1, grid2, n, m, vis);
        return left && right && up && down;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;

        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && bfs(i, j, grid1, grid2, n, m, vis) && grid2[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}