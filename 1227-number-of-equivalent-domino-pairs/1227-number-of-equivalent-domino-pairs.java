class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] map = new int[10][10];
        int result = 0;

        for(int i=0; i<dominoes.length; i++){
            if(dominoes[i][0] < dominoes[i][1]){
                result += map[dominoes[i][0]][dominoes[i][1]];
                map[dominoes[i][0]][dominoes[i][1]]++;
            }else{
                result += map[dominoes[i][1]][dominoes[i][0]];
                map[dominoes[i][1]][dominoes[i][0]]++;
            }
        }
        return result;
    }
}