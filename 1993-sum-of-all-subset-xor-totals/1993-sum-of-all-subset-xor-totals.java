class Solution {

    public int subsets(int[] nums, int n, int start, int xor){
        int result = xor;
        for(int i=start; i<n; i++){
            xor ^= nums[i];
            result += subsets(nums, n, i+1, xor);
            xor ^= nums[i];
        }
        return result;
    }

    public int subsetXORSum(int[] nums) {
        int result = subsets(nums, nums.length, 0, 0);
        return result;
    }
}