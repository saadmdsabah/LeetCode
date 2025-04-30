class Solution {

    public int maxP(int[] prices, int buy, int[][] dp, int index){
        if(index >= prices.length){
            return 0;
        }
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        int profit = 0;

        if(buy == 1){
            int take = -prices[index] + maxP(prices, 0, dp, index+1);
            int notTake = maxP(prices, 1, dp, index+1);
            profit = Math.max(take, notTake);
        }else{
            int sell = prices[index] + maxP(prices, 1, dp, index+2);
            int notSell = maxP(prices, 0, dp, index+1);
            profit = Math.max(sell, notSell);
        }
        return dp[index][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+2][2];
        for(int index=prices.length-1; index>=0; index--){
            for(int buy=0; buy<2; buy++){
                int profit = 0;
                if(buy == 1){
                    int take = -prices[index] + dp[index+1][0];
                    int notTake = dp[index+1][1];
                    profit = Math.max(take, notTake);
                }else{
                    int sell = prices[index] + dp[index+2][1];
                    int notSell = dp[index+1][0];
                    profit = Math.max(sell, notSell);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }
}