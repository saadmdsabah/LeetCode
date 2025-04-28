class Solution {
    public long countSubarrays(int[] nums, long k) {
        int s = 0;
        int e = 0;
        // long computation = 0;
        long count = 0;
        long sum = 0;

        while(e < nums.length){
            if(nums[e] >= k){
                s = e + 1;
                sum = 0;
                e++;
                continue;
            }
            sum += nums[e];
            // computation = sum*(e - s + 1);
            while((long)(sum*(e - s + 1)) >= k && s < e){
                sum -= nums[s];
                s++;
                // computation = sum*(e - s + 1);
            }
            count += e - s + 1;
            e++;
        }
        return count;
    }
}