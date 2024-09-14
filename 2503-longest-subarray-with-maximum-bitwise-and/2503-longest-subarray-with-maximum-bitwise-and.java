class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int i : nums){
            max = Math.max(max, i);
        }
        int maxLength = 0;
        for(int i=0; i<nums.length; i++){
            int length = 0;
            if(nums[i] == max){
                while(i < nums.length && nums[i] == max){
                    length++;
                    maxLength = Math.max(maxLength, length);
                    i++;
                }
                i-=1;
            }
        }
        return maxLength;
    }
}