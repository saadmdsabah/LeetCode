class Solution {

    public int countSum(int[] nums, int target, int index, int curr, int[][] dp){
        if(target == curr){
            return 1;
        }
        if(index == nums.length){
            return 0;
        }
        if(dp[index][curr] != -1){
            return dp[index][curr];
        }
        int takeSame = 0;
        int takeAndGo = 0;
        if(nums[index] + curr <= target){
            takeAndGo = countSum(nums, target, 0, curr + nums[index], dp);
        }
        int notTake = countSum(nums, target, index+1, curr, dp);
        return dp[index][curr] = takeSame + takeAndGo + notTake;
    }

    public int combinationSum4(int[] nums, int target) {
        int[][] dp = new int[nums.length][target+1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return countSum(nums, target, 0, 0, dp);
    }
}