class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        int s = 0;
        int e = nums.length - 1;
        while(s<=e){
            ans[s] = nums[nums[s]];
            ans[e] = nums[nums[e]];
            s++;e--;
        }
        return ans;
    }
}