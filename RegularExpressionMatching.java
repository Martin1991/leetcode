public class solution{
	public boolean isMatch(String s, String p){
		int m = s.length(), n = p.length();
		
		// one more space to check either one of them is null
		boolean[][] dp = new boolean[m+1][n+1];
		
		dp[0][0] = true;
		
		for(int j = 1; j<=n; j++){
		
			if(p.charAt(j-1) == '*'){
				dp[0][j] = dp[0][j-2];
			}
			
		}
		
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
				
					dp[i][j] = true;
					
				}else if(p.charAt(j-1) == '*'){
				
					//if * indicates that there are only 0 or * indicates more than 0 characters
					dp[i][j] = dp[i][j-2] || (dp[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) || (p.charAt(j-2) == '.')));
					
				}else dp[i][j] = false;
			}
		}
		return dp[m][n];
	}
}