class Solution {

    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] result = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                result[i][j] = image[i][j];
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        result[sr][sc] = color;
        visited[sr][sc] = true;

        while(!q.isEmpty()){
            Pair currPair = q.remove();
            int x = currPair.x;
            int y = currPair.y;
            int[] xd = {-1,1,0,0};
            int[] yd = {0,0,-1,1};
            for(int i=0; i<4; i++){
                int newX = x + xd[i];
                int newY = y + yd[i];
                if(newX >= 0 && newX < n && newY >=0 && newY < m && image[newX][newY] == image[x][y] && !visited[newX][newY]){
                    result[newX][newY] = color;
                    q.add(new Pair(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
        return result;
    }
}