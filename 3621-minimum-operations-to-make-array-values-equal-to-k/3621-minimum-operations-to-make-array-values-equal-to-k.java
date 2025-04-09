class Solution {
    public int minOperations(int[] nums, int k) {
        int[] dist = new int[101];

        for(int i=nums.length-1; i>=0; i--){
            if(dist[nums[i]] == 0){
                dist[0]++;
            }
            dist[nums[i]]++;
        }
        int min = -1;
        for(int i=1; i<=100; i++){
            if(dist[i] != 0){
                min = i;
                break;
            }
        }
        int count = dist[0] - 1;
        if(k > min){
            return -1;
        }else if(k == min){
            return count;
        }
        return count + 1;
    }
}