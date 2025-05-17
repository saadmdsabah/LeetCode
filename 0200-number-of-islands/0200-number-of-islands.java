class Solution {

    public void dfs(char[][] grid, int x, int y, boolean[][] visited){
        if(visited[x][y]){
            return;
        }
        visited[x][y] = true;
        int[] xd = {-1, 1, 0, 0};
        int[] yd = {0, 0, -1, 1};
        for(int i=0; i<4; i++){
            if(x + xd[i] >= 0 && x + xd[i] < grid.length && y + yd[i] >= 0 && y + yd[i] < grid[0].length && !visited[x+xd[i]][y+yd[i]] && grid[x+xd[i]][y+yd[i]] == '1'){
                dfs(grid, x+xd[i], y+yd[i], visited);
            }
        }
    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }
}