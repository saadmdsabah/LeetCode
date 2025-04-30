class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        if(stack.isEmpty()){
            return result;
        }
        for(int i=0; i<nums.length-1; i++){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                int index = stack.pop();
                result[index] = nums[i];
            }
        }
        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
        return result;
    }
}