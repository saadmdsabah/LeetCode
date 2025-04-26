class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int prevMin = -1;
        int prevMax = -1;
        int i = 0;
        int j = 0;

        while(j < nums.length){
            if(nums[j] == minK){
                prevMin = j;
            }
            if(nums[j] == maxK){
                prevMax = j;
            }
            if(nums[j] > maxK || nums[j] < minK){
                i = j+1;
                prevMin = -1;
                prevMax = -1;
            }
            if(Math.min(prevMin, prevMax) != -1){
                ans += Math.min(prevMin, prevMax) - i + 1;
            }
            j++;
        }
        return ans;
    }
}