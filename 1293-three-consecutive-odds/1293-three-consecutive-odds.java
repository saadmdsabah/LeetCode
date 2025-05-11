class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int t = 0;
        for(int i : arr){
            t = i%2 != 0 ? t + 1 : 0;
            if(t == 3){
                return true;
            }
        }
        return false;
    }
}