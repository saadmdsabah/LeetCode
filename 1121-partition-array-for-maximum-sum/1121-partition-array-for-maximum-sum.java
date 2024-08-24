class Solution {

    public int maxSum(int[] arr, int k, int i, int[] dp){
        if(i >= arr.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int take = 0;
        int nottake = 0;
        int localmax = 0;
        for(int j=1; j<=k;j++){
            int count = 0;
            for(int index=i; index<i+j && index<arr.length; index++){
                localmax = Math.max(localmax, arr[index]);
                count++;
            }
            take = Math.max(take, (count)*localmax + maxSum(arr, k, i+count ,dp));
        }
        nottake = arr[i] + maxSum(arr, k, i+1, dp);
        return dp[i] = Math.max(take, nottake);
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return maxSum(arr, k, 0 ,dp);
    }
}