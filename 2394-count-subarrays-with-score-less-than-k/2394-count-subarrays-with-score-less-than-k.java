class Solution {
    public long countSubarrays(int[] nums, long k) {
        int s = 0;
        int e = 0;
        long count = 0;
        long sum = 0;

        while(e < nums.length){
            sum += nums[e];
            while(sum*(e - s + 1) >= k){
                sum -= nums[s];
                s++;
            }
            count += e - s + 1;
            e++;
        }
        return count;
    }
}