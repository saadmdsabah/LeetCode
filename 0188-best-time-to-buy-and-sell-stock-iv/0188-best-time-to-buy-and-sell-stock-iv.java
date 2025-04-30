class Solution {

    public int maxP(int k, int[] prices, int buy, int index, int[][][] dp){
        if(k == 0){
            return 0;
        }
        if(index == prices.length){
            return 0;
        }
        if(dp[index][buy][k] != -1){
            return dp[index][buy][k];
        }

        int profit = 0;
        if(buy == 1){
            int take = -prices[index] + maxP(k, prices, 0, index + 1, dp);
            int notTake = maxP(k, prices, 1, index + 1, dp);
            profit = Math.max(take, notTake);
        }else{
            int sell = prices[index] + maxP(k-1, prices, 1, index+1, dp);
            int notSell = maxP(k, prices, 0, index+1, dp);
            profit = Math.max(sell, notSell);
        }
        return dp[index][buy][k] = profit;
    }

    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k+1];
        for(int i=0; i<prices.length; i++){
            for(int j=0; j<2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return maxP(k, prices, 1, 0, dp);
    }
}