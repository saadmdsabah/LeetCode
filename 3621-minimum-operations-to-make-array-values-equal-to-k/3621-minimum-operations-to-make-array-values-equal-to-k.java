class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int prev = nums[n-1];
        int count = 0;

        for(int i=nums.length-1; i>=0; i--){
            if(prev != nums[i]){
                count++;
            }
            prev = nums[i];
        }
        if(k > prev){
            return -1;
        }else if(k == prev){
            return count;
        }
        return count + 1;
    }
}