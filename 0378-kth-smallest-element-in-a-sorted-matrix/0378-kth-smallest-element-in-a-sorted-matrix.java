class Solution {

    public int upperBound(int [][] matrix, int target){
        int count = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0; i<n; i++){
            int low = 0, high = m - 1;
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(matrix[i][mid] <= target){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            count += low;
        }
        return count;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[n-1][m-1];

        while(low < high){
            int mid = low + (high - low) / 2;
            int count = upperBound(matrix, mid);
            if(count >= k){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
