class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int curr = nums[right] + nums[left] + nums[i];
                if(curr == 0){
                    set.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                }else if(curr < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}