class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; 

        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int jump = questions[i][1];

            long take = points + (i + jump + 1 < n ? dp[i + jump + 1] : 0);

            long skip = dp[i + 1];

            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }
}
