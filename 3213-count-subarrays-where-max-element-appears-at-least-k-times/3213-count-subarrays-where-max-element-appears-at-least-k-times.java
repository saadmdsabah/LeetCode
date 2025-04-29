class Solution {
    public long countSubarrays(int[] nums, int k) {
        long result = 0;
        int max = 0;
        for(int i : nums){
            max = Math.max(max, i);
        }

        int start = 0;
        int count = 0;
        for(int end=0; end<nums.length; end++){
            if(nums[end] == max){
                count++;
            }
            while(count >= k){
                result += nums.length - end;
                if(nums[start] == max){
                    count--;
                }
                start++;
            }
        }
        return result;
    }
}