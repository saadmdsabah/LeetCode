class Solution {

    public ArrayList<Integer> largest(int[] nums, int index, ArrayList<Integer>[] dp){
        if(dp[index] != null){
            return dp[index];
        }

        ArrayList<Integer> maxList = new ArrayList<>();
        maxList.add(nums[index]);
        for(int next = index + 1; next < nums.length; next++){
            if(nums[next]%nums[index] == 0){
                ArrayList<Integer> current = largest(nums, next, dp);
                if(current.size() + 1 > maxList.size()){
                    maxList = new ArrayList<>();
                    maxList.add(nums[index]);
                    maxList.addAll(current);
                }
            }
            
        }
        dp[index] = maxList;
        return dp[index];
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer>[] dp = new ArrayList[nums.length];
        ArrayList<Integer> max = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            ArrayList<Integer> temp = largest(nums, i, dp);
            if(temp.size() > max.size()){
                max = temp;
            }
        }
        return max;
    }
}