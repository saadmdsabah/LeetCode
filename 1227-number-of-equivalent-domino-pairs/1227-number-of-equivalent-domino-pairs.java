class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] map = new int[10][10];
        int result = 0;

        for(int i=0; i<dominoes.length; i++){
            int x = Math.min(dominoes[i][0], dominoes[i][1]);
            int y = Math.max(dominoes[i][1], dominoes[i][0]);
            result += map[x][y];
            map[x][y]++;
        }
        return result;
    }
}