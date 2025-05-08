import java.util.*;

class Solution {

    class Pair{
        int x;
        int y;
        int value;
        int parity;
        public Pair(int x, int y, int v, int p){
            this.x = x;
            this.y = y;
            this.value = v;
            this.parity = p;
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] values = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(values[i], Integer.MAX_VALUE);
        }

        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
        values[0][0] = 0;
        pq.add(new Pair(0, 0, 0, 1));
        int[] xVal = {-1, 1, 0, 0};
        int[] yVal = {0, 0, -1, 1};

        while(!pq.isEmpty()){
            Pair currPair = pq.remove();
            int x = currPair.x;
            int y = currPair.y;
            int currValue = currPair.value;
            int currParity = currPair.parity;
            visited[x][y] = true;

            for(int i=0; i<4; i++){
                int newX = x + xVal[i];
                int newY = y + yVal[i];
                if(newX < 0 || newX >= n || newY < 0 || newY >= m || visited[newX][newY]) continue;
                int newValue = moveTime[newX][newY] + currParity;
                if(moveTime[newX][newY] <= currValue){
                    newValue = currValue + currParity;
                }
                if(newValue < values[newX][newY]){
                    values[newX][newY] = newValue;
                    pq.add(new Pair(newX, newY, newValue, currParity == 1 ? 2 : 1));
                }
            }
        }
        return values[n-1][m - 1];
    }
}
