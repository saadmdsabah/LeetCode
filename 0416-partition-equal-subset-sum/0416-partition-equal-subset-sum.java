public class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        
        // Calculate total sum of all elements
        for (int num : nums) {
            totalSum += num;
        }
        
        // If the total sum is odd, we can't divide it into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int target = totalSum / 2;
        
        // dp[i] means whether we can sum up to i using elements from the array
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // We can always sum to 0 with an empty subset
        
        for (int num : nums) {
            // Traverse backwards to avoid using the same number more than once
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        
        return dp[target];
    }
}
