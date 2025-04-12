class Solution {

    public int count(String s, int index, int count, int[][][] dp, int tight){
        if(index == s.length()){
            return count;
        }
        if(dp[index][tight][count] != -1){
            return dp[index][tight][count];
        }
        int limit = tight == 1 ? (int) (s.charAt(index) - '0') : 9;
        int ans = 0;
        for(int i=0; i<=limit; i++){
            int updateCount = count + (i == 1 ? 1 : 0);
            int newTight = (tight == 1 && i == s.charAt(index) - '0') ? 1 : 0;
            ans += count(s, index+1, updateCount, dp, newTight);
        }
        return dp[index][tight][count] = ans;
    }

    public int countDigitOne(int n) {
        int[][][] dp = new int[12][2][12];
        for(int i=0; i<12; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<12; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        String s = String.valueOf(n);
        return count(s, 0, 0, dp, 1);
    }
}