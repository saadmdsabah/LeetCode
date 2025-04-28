class Solution {
    public long countSubarrays(int[] nums, long k) {
        int s = 0;
        long sum = 0, count = 0;

        for (int e = 0; e < nums.length; e++) {
            sum += nums[e];
            while (sum * (e - s + 1) >= k) {
                sum -= nums[s++];
            }
            count += e - s + 1;
        }

        return count;
    }
}
