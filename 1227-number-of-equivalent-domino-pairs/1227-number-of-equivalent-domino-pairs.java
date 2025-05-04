class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] map = new int[100]; 
        int result = 0;

        for (int[] domino : dominoes) {
            int a = domino[0], b = domino[1];
            int key = a < b ? a * 10 + b : b * 10 + a;
            result += map[key];
            map[key]++;
        }

        return result;
    }
}
