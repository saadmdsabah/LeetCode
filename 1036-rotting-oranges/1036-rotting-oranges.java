class Solution {

    class Pair {
        int x;
        int y;
        int t;

        public Pair(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        int maxTime = 0;

        // Step 1: Add all initially rotten oranges to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        // Step 2: BFS from all rotten oranges simultaneously
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            int time = curr.t;

            maxTime = Math.max(maxTime, time);

            for (int dir = 0; dir < 4; dir++) {
                int newX = x + dx[dir];
                int newY = y + dy[dir];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m &&
                    !visited[newX][newY] && grid[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    grid[newX][newY] = 2; // now rotten
                    q.add(new Pair(newX, newY, time + 1));
                }
            }
        }

        // Step 3: Check for any remaining fresh orange
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return maxTime;
    }
}
