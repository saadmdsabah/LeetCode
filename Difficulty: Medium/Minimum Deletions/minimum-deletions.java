class Solution {
    public static int palindromString(int i, int j, String s, int[][] dp){
        if(i >= j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int min = (int) 1e9;
        int notEqual = (int) 1e9;
        if(s.charAt(i) != s.charAt(j)){
            int first = 1 + palindromString(i+1, j, s, dp);
            int last = 1 + palindromString(i, j-1, s, dp);
            int both = 2 + palindromString(i+1, j-1, s, dp);
            min = Math.min(min, Math.min(Math.min(first, last), both));
        }else{
            min = Math.min(min, palindromString(i+1, j-1, s, dp));
        }
        return dp[i][j] = min;
    }
    
    static int minDeletions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return palindromString(0, s.length() - 1, s, dp);
    }
}