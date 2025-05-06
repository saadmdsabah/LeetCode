class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0; i<=nums.length/2; i++){
            ans[i] = nums[nums[i]];
            ans[nums.length - i - 1] = nums[nums[nums.length - i - 1]];
        }
        return ans;
    }
}