class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if(nums[0] + nums[1] <= nums[2]){ // none
            return "none";
        }else if(nums[0] == nums[1] && nums[1] == nums[2]){ // eq
            return "equilateral";
        }else if(nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2]){ // is
            return "isosceles";
        }else{ // sc
            return "scalene";
        }
    }
}