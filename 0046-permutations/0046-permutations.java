class Solution {

    private void swap(int index, int[] nums, int i){
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }

    private void helperFunction(int[] nums, int index, List<List<Integer>> list){
        if(index == nums.length){
            List<Integer> innerList = Arrays.stream(nums).boxed().collect(Collectors.toList());
            list.add(innerList);
            return;
        }
        for(int i=index; i<nums.length; i++){
            swap(i, nums, index);
            helperFunction(nums, index+1, list);
            swap(i, nums, index);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helperFunction(nums, 0, list);
        return list;
    }
}