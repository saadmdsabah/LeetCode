class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] result = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                boolean zeroPresent = false;
                for(int k=0; k<m; k++){
                    if(matrix[i][k] == 0){
                        zeroPresent = true;
                        break;
                    }
                }
                if(!zeroPresent){
                    for(int k=0; k<n; k++){
                        if(matrix[k][j] == 0){
                            zeroPresent = true;
                            break;
                        }
                    }
                }
                if(zeroPresent) result[i][j] = 0;
                else result[i][j] = matrix[i][j];
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }
}