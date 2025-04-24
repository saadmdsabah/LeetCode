class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int[] map = new int[2001];
        int unique = 0;
        for(int i=0; i<nums.length; i++){
            if(map[nums[i]] == 0){
                unique++;
            }
            map[nums[i]]++;
        }
        Arrays.fill(map, 0);

        int tUni = 0;
        int count = 0;
        for(int j=0; j<nums.length; j++){
            if(map[nums[j]] == 0){
                tUni++;
            }
            map[nums[j]]++;
            int[] temp = map.clone();
            int ttUni = tUni;

            for(int i=0; i<=j; i++){
                if(ttUni == unique){
                    count += 1;
                }
                if(temp[nums[i]] == 1){
                    ttUni--;
                }
                temp[nums[i]]--;
            }
        }
        return count;
    }
}