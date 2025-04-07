public class Solution {

    public boolean can(int[] nums, int total, int current, int index, int[][] dp){
        if(current == total/2){
            return true;
        }else if(index >= nums.length){
            return false;
        }else if(dp[index][current] != -1){
            return dp[index][current] == 1;
        }
        boolean result = can(nums, total, current + nums[index], index+1, dp) || can(nums, total, current, index+1, dp);
        dp[index][current] = result ? 1 : 0;
        return result;
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i : nums){
            total += i;
        }
        if(total%2 != 0){
            return false;
        }
        int[][] dp = new int[nums.length][total + 1];
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<=total; j++){
                dp[i][j] = -1;
            }
        }

        return can(nums,total, 0, 0, dp);
    }
}