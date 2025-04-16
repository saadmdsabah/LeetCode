class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer, Long> freq = new HashMap<>();
        int n = nums.length;
        long count = 0;
        long result = 0;
        int i = 0;
        int j = 0;

        while(j < n){
            if(freq.containsKey(nums[j])){
                freq.put(nums[j], freq.get(nums[j]) + 1);
            }else{
                freq.put(nums[j], (long) 1);
            }
            count += freq.get(nums[j]) - 1;
            while(count >= k && i <= j){
                result += n - j;
                count -= freq.get(nums[i]) - 1;
                freq.put(nums[i], freq.get(nums[i]) - 1); 
                i++;
            }
            j++;
        }
        return result;
    }
}