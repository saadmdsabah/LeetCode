class Solution {
    public long maximumTripletValue(int[] nums) {
        int[] rightMaxArray = new int[nums.length];
        int[] leftMaxArray = new int[nums.length];
        
        int rightMax = 0;
        int leftMax = 0;

        for(int i=nums.length - 1; i>=0; i--){
            rightMaxArray[i] = rightMax;
            rightMax = Math.max(rightMax, nums[i]);
        }
        for(int i=0; i<nums.length; i++){
            leftMaxArray[i] = leftMax;
            leftMax = Math.max(leftMax, nums[i]);
        }

        long result = 0;
        for(int i=0; i<nums.length; i++){
            int sub = leftMaxArray[i] - nums[i];
            long value = (long)sub*rightMaxArray[i];
            if(value > result){
                result = value;
            }
        }
        return result;
    }
}