import java.util.*;

class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        Long[] newNums = new Long[nums.length]; 
        long sum = 0;

        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            newNums[i] = (long)((nums[i] ^ k) - nums[i]);
        }
        
        Arrays.sort(newNums, Collections.reverseOrder()); 
        for (int i = 0; i < nums.length - 1; i+=2) {
            long newProfit = newNums[i] + newNums[i + 1];
            if (newProfit > 0) {
                sum += newProfit;
            }
        }
        return sum;
    }
}
