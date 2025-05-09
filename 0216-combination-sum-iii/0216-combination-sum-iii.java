class Solution {

    List<List<Integer>> result = new ArrayList<>();
    public void combination(int k, int n, int curr, List<Integer> list, int[] nums, int index){
        if(curr == n && k == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(index == nums.length || k < 0){
            return;
        }
        if(curr + nums[index] <= n){
            list.add(nums[index]);
            combination(k-1, n, curr+nums[index], list, nums, index+1);
            list.remove(list.size() - 1);
        }
        combination(k, n, curr, list, nums, index + 1);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        for(int i=0; i<nums.length; i++){
            nums[i] = i+1;
        }
        combination(k, n, 0, new ArrayList<Integer>(), nums, 0);
        return result;
    }
}