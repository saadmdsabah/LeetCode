class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length+1][2];
        for(int index=prices.length - 1; index>=0; index--){
            for(int buy=0; buy<2; buy++){
                int profit = 0;
                if(buy == 1){
                    int take = -prices[index] + dp[index+1][0];
                    int notTake = dp[index+1][1];
                    profit = Math.max(take, notTake);
                }else{
                    int sell = prices[index] + dp[index+1][1] - fee;
                    int notSell = dp[index+1][0];
                    profit = Math.max(sell, notSell);
                }

                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }
}