class Solution {
    
    public static int dpNoWays(int m, int n, int x, int[][] dp) {
        if(n == 0){
            if(x == 0) return 1;
            else return 0;
        }
        if(dp[n][x] != -1){
            return dp[n][x];
        }
        
        
        int ans = 0;
        for(int i=1; i<=m; i++){
            if(x - i >= 0){
                ans += dpNoWays(m, n-1, x-i, dp);
            }
        }
        return dp[n][x] = ans;
    }
    
    static int noOfWays(int m, int n, int x) {
        int[][] dp = new int[n+1][x+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=x; j++){
                dp[i][j] = -1;
            }
        }
        return dpNoWays(m, n, x, dp);
    }
};