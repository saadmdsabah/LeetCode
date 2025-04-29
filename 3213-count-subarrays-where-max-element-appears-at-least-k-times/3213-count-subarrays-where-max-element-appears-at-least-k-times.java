class Solution {
    public long countSubarrays(int[] nums, int k) {
        long result = 0;
        int max = 0;
        for(int i : nums){
            if(i > max){
                max = i;
            }
        }

        int start = 0;
        int end = 0;
        int count = 0;
        while(end < nums.length){
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
            end++;
        }
        return result;
    }
}