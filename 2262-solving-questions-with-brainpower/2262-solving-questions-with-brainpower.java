class Solution {

    public long pointsRecursion(int[][] questions, int index, long[] dp){
        if(index >= questions.length){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        long take = pointsRecursion(questions, index + questions[index][1] + 1, dp) + questions[index][0];
        long notTake = pointsRecursion(questions, index+1, dp);
        dp[index] = Math.max(take, notTake);
        return dp[index]; 
    }

    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        long max = pointsRecursion(questions, 0, dp);
        return max;
    }
}