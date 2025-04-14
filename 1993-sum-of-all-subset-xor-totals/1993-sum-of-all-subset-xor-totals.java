class Solution {

    public int subsets(int[] nums, int n, int start, int xor){
        if(start == n){
            return xor;
        }
        return subsets(nums, n, start+1, xor^nums[start]) + subsets(nums, n, start+1, xor);
    }

    public int subsetXORSum(int[] nums) {
        int result = subsets(nums, nums.length, 0, 0);
        return result;
    }
}