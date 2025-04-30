class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i : nums){
            int t = 0;
            while(i > 0){
                t++;
                i = i/10;
            }
            if(t%2 == 0) count++;
        }
        return count;
    }
}