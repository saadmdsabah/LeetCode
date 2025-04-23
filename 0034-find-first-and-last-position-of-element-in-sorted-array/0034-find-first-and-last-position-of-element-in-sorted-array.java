class Solution {

    public int firstIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while(low <= high){
            int mid = (high - low)/2 + low;
            if(nums[mid] == target){
                index = mid;
                high = mid - 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return index;
    }

    public int lastIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while(low <= high){
            int mid = (high - low)/2 + low;
            if(nums[mid] == target){
                index = mid;
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return index;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{firstIndex(nums, target),lastIndex(nums, target)};
    }
}