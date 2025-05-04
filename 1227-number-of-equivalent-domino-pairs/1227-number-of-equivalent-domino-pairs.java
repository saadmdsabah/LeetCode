class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] map = new int[10][10];
        int result = 0;

        for(int i=0; i<dominoes.length; i++){
            result += map[Math.min(dominoes[i][0], dominoes[i][1])][Math.max(dominoes[i][1], dominoes[i][0])];
            map[Math.min(dominoes[i][1], dominoes[i][0])][Math.max(dominoes[i][1], dominoes[i][0])]++;
        }
        return result;
    }
}