class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int min = 101;

        for(int i=nums.length-1; i>=0; i--){
            set.add(nums[i]);
            min = Math.min(min, nums[i]);
        }
        int count = set.size() - 1;
        if(k > min){
            return -1;
        }else if(k == min){
            return count;
        }
        return count + 1;
    }
}