import java.util.*;

class Solution {

    class Pair {
        int value;
        int x;
        int y;
        public Pair(int v, int x , int y){
            this.value = v;
            this.x = x;
            this.y = y;
        }
    }

    public void dijkstra(int[][] moveTime, int[][] values, int n, int m){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        pq.add(new Pair(0, 0, 0));
        values[0][0] = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            int value = curr.value;

            if (value > values[x][y]) continue;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int wait = Math.max(0, moveTime[nx][ny] - value);
                    int newValue = value + wait + 1;

                    if (newValue < values[nx][ny]) {
                        values[nx][ny] = newValue;
                        pq.add(new Pair(newValue, nx, ny));
                    }
                }
            }
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] values = new int[n][m];
        for (int[] row : values) Arrays.fill(row, Integer.MAX_VALUE);

        dijkstra(moveTime, values, n, m);
        return values[n - 1][m - 1];
    }
}
