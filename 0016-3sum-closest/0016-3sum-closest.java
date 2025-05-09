class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE; 

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return target; // exact match found
                }
            }
        }

        return result;
    }
}
