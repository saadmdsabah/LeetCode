class Solution {
    public int maxProfit(int[] prices) {
        int profit1 = 0;
        int profit2 = 0;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++){
            int curr1 = prices[i] - min1;
            if(curr1 > profit1){
                profit1 = curr1;
            }
            min1 = Math.min(min1, prices[i]);

            int curr2 = prices[i] - min2;
            if(curr2 > profit2){
                profit2 = curr2;
            }
            min2 = Math.min(min2, prices[i] - profit1);
        }
        return profit2;
    }
}