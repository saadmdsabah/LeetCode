class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startingX = 0;
        int startingY = matrix[0].length - 1;

        while(startingY >= 0 && startingX < matrix.length){
            if(matrix[startingX][startingY] == target){
                return true;
            }else if(matrix[startingX][startingY] > target){
                startingY--;
            }else{
                startingX++;
            }
        }
        return false;
    }
}