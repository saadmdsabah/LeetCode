class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int low = 0;
        int high = rows*columns-1;

        while(low <= high){
            int mid = (high - low)/2 + low;
            int x = mid/columns;
            int y = mid%columns;
            if(matrix[x][y] == target){
                return true;
            }else if(matrix[x][y] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
}