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