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
        int[][] dp = new int[prices.length][2];
        for(int i=0; i<prices.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return maxP(prices, 1, dp, 0);
    }
}