class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int min = -1;
        int max = -1;
        int start = 0;
        long count = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == minK){
                min = i;
            }
            if(nums[i] == maxK){
                max = i;
            }
            if(nums[i] > maxK || nums[i] < minK){
                start = i + 1;
                min = -1;
                max = -1;
            }
            if(Math.min(min, max) != -1){
                count += Math.min(min, max) - start + 1;
            }
        }
        return count;
    }
}