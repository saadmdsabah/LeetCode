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
        int[][][] values = new int[moveTime.length][moveTime[0].length][2];

        for(int i=0; i<values.length; i++){
            for(int j=0; j<values[i].length; j++){
                Arrays.fill(values[i][j], Integer.MAX_VALUE);
            }
        }

        boolean[][][] visited = new boolean[moveTime.length][moveTime[0].length][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        values[0][0][0] = 0;
        values[0][0][1] = 0;
        pq.add(new Pair(0, 0, 0, 1));
        int[] xVal = {-1, 1, 0, 0};
        int[] yVal = {0, 0, -1, 1};

        while(!pq.isEmpty()){
            Pair currPair = pq.remove();
            int x = currPair.x;
            int y = currPair.y;
            int currValue = currPair.value;
            int currParity = currPair.parity;
            visited[x][y][currParity - 1] = true;

            int newParity = currParity == 1 ? 2 : 1;
            for(int i=0; i<4; i++){
                int newX = x + xVal[i];
                int newY = y + yVal[i];
                if(newX >= 0 && newX < moveTime.length && newY >= 0 && newY < moveTime[0].length){
                    if(!visited[newX][newY][currParity - 1]){
                        int newValue = moveTime[newX][newY] + currParity;
                        if(moveTime[newX][newY] <= currValue){
                            newValue = currValue + currParity;
                        }
                        if(newValue < values[newX][newY][currParity - 1]){
                            values[newX][newY][currParity - 1] = newValue;
                            pq.add(new Pair(newX, newY, newValue, newParity));
                        }
                    }
                }
            }
        }
        return Math.min(values[values.length - 1][values[0].length - 1][0], values[values.length - 1][values[0].length - 1][1]);
    }
}
