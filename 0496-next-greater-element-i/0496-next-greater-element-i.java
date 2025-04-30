class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], i);
        }

        for(int i=0; i<nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                int element = stack.pop();
                int index = map.get(element);
                nums1[index] = nums2[i];
            }
            if(map.containsKey(nums2[i])){
                stack.push(nums2[i]);
            }
        }
        while(!stack.isEmpty()){
            int element = stack.pop();
            int index = map.get(element);
            nums1[index] = -1;
        }
        return nums1;
    }
}