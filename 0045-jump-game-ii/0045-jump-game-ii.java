class Solution {

    public int minJump(int[] nums, int i, int[] dp){
        if(i >= nums.length-1){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int result = 10000000;
        for(int j=1; j<=nums[i]; j++){
            result = Math.min(result, 1 + minJump(nums, i+j, dp));
        }
        return dp[i] = result;
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            dp[i] = -1;
        }
        return minJump(nums, 0, dp);
    }
}