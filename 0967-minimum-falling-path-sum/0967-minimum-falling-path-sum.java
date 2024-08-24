class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // Base case: copy the first row of the matrix to the dp array
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill the dp array from top to bottom
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int down = matrix[i][j] + dp[i - 1][j];
                int left = matrix[i][j];
                if (j - 1 >= 0) {
                    left += dp[i - 1][j - 1];
                } else {
                    left += (int)(1e9);
                }
                int right = matrix[i][j];
                if (j + 1 < n) {
                    right += dp[i - 1][j + 1];
                } else {
                    right += (int)(1e9);
                }
                dp[i][j] = Math.min(down, Math.min(left, right));
            }
        }

        // Find the minimum value in the last row of the dp array
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            result = Math.min(result, dp[n - 1][j]);
        }

        return result;
    }
}