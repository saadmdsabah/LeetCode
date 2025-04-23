class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;

        while(low < high){
            int mid = (high - low)/2 + low;
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
                return nums[mid];
            }else if(nums[mid] == nums[mid - 1]){
                if(((mid - 1) - low)%2 == 0){
                    low = mid + 1;
                }else{
                    high = mid - 2;
                }
            }else{
                if(((mid + 1) - high)%2 == 0){
                    high = mid - 1;
                }else{
                    low = mid + 2;
                }
            }
        }

        return nums[high];
    }
}