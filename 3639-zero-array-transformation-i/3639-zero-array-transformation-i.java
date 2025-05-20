class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] prefix = new int[nums.length];

        for(int i=0; i<queries.length; i++){
            int startingIndex = queries[i][0];
            int endingIndex = queries[i][1];

            prefix[startingIndex]--;
            if(endingIndex + 1 < nums.length){
                prefix[endingIndex + 1]++;
            }
        }

        for(int i=1; i<prefix.length; i++){
            prefix[i] += prefix[i-1];
        }

        for(int i=0; i<prefix.length; i++){
            nums[i] = nums[i] + prefix[i];
            if(nums[i] > 0){
                return false;
            }
        }
        return true;
    }
}