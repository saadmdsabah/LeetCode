class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length <= 3){
            List<List<Integer>> result = new ArrayList<>();
            return result;
        }
        Arrays.sort(nums);

        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int i=0; i<nums.length - 3; i++){
            for(int j=i+1; j<nums.length - 2; j++){
                int left = j+1;
                int right = nums.length - 1;
                while(left < right){
                    long curr = (long) nums[left] + nums[right] + nums[i] + nums[j];
                    if(curr == target){
                        set.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        left++;
                        right--;
                    }else if(curr < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}