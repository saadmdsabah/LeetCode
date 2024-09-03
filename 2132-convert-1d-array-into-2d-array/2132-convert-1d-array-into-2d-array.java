class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result = new int[m][n];
        int index = 0;
        if(original.length - m*n != 0){
            return new int[0][0];
        }
        if(m==1 && n==1 && original.length==1){
            result[0][0] = original[0];
            return result;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result[i][j] = original[index];
                index++;
            }
        }
        
        return result;
    }
}