class Solution {

    class Pair{
        int row;
        int col;
        public Pair(int r, int c){
            this.row = r;
            this.col = c;
        }
    }

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        HashSet<Pair> set = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){
                    set.add(new Pair(i, j));
                }
            }
        }

        for(Pair p : set){
            Pair currPair = p;
            int row = p.row;
            int col = p.col;

            for(int i=0; i<n; i++){
                matrix[i][col] = 0;
            }
            for(int i=0; i<m; i++){
                matrix[row][i] = 0;
            }
        }
    }
}