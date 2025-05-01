class Solution {
    public int trap(int[] height) {
        int[] rightMax = new int[height.length];
        int[] leftMax = new int[height.length];

        int right = height[height.length - 1];
        int left = height[0];
        for(int i=0; i<height.length; i++){
            leftMax[i] = left;
            left = Math.max(left, height[i]);
        }
        for(int i=height.length-1; i>=0; i--){
            rightMax[i] = right;
            right = Math.max(right, height[i]);
        }
        int result = 0;
        for(int i=0; i<height.length; i++){
            int curr = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(curr > 0){
                result += curr;
            }
        }
        return result;
    }
}