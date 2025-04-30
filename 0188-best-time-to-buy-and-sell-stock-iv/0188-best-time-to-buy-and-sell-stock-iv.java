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

    public int maxProfit(int max, int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][max+1];
        for(int index=prices.length - 1; index>=0; index--){
            for(int buy=0; buy<2; buy++){
                for(int k = max; k>0; k--){
                    int profit = 0;
                    if(buy == 1){
                        int take = -prices[index] + dp[index+1][0][k];
                        int notTake = dp[index+1][1][k];
                        profit = Math.max(take, notTake);
                    }else{
                        int sell = prices[index] + dp[index+1][1][k-1];
                        int notSell = + dp[index+1][0][k];
                        profit = Math.max(sell, notSell);
                    }
                    dp[index][buy][k] = profit;
                }
            }
        }
        // return maxP(k, prices, 1, 0, dp);
        return dp[0][1][max];
    }
}