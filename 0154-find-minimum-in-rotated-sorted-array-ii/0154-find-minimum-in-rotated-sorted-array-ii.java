class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int result = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low+high)/2;
            result = Math.min(result, nums[mid]);
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
            }else if(nums[mid] >= nums[low]){
                result = Math.min(result, nums[low]);
                low = mid + 1;
            }else{
                result = Math.min(result, nums[high]);
                high = mid - 1;
            }
        }
        return result;
    }
}