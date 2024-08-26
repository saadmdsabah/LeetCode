class Solution {

    public boolean match(String s, String p, int i, int j, int[][] dp){
		if(i < 0 && j < 0){
			return true;
		}
		else if(i < 0){
			for(; j>=0; j--){
				if(p.charAt(j) == '*'){
					j--;
				}else{
					return false;
				}
			}
			return true;
		}else if(j < 0){
			return false;
		}
		if(dp[i][j] != -1){
			return dp[i][j] == 1;
		}

		if(s.charAt(i) == p.charAt(j)){
			dp[i][j] = match(s, p, i-1, j-1, dp) == true ? 1 : 0;
			return dp[i][j] == 1;
		}
		else if(p.charAt(j) == '*'){
			if(s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                dp[i][j] = match(s,p,i-1,j,dp) || match(s,p,i,j-2,dp) == true ? 1 : 0;
                return dp[i][j] == 1;
            }else{
                dp[i][j] = match(s,p,i,j-2,dp) == true ? 1 : 0;
                return dp[i][j] == 1;
            }
		}else if(p.charAt(j) == '.'){
			dp[i][j] = match(s, p, i-1, j-1, dp) == true ? 1 : 0;
			return dp[i][j] == 1;
		}else{
			dp[i][j] = 0;
			return false;
		}
	}

    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
		for(int i[] : dp){
			Arrays.fill(i, -1);
		}
		return match(s, p, s.length()-1, p.length()-1, dp);
    }
}