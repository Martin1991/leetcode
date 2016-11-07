
public class PaintHouseII_265 {
	
	//O(nk^2) time, O(nk) space
	public static int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        if(k == 1) return (n==1? costs[0][0] : -1);
        
        int[][] dp = new int[n][k];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<k; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int j = 0; j<k; j++){
            dp[0][j] = costs[0][j];
        }
        
        for(int i = 1; i<n; i++){
            for(int j = 0; j<k; j++){
                for(int l = 0; l<k; l++){
                    if(l!=j){
                        dp[i][j] = Math.min(dp[i-1][l]+costs[i][j], dp[i][j]);
                        
                    }
                }
                
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j<k; j++){
            min = Math.min(dp[n-1][j],min);
        }
        
        return min;
    }
	
	//O(nk) time, O(1) space
	public static int minCostII2(int[][] costs) {
        //base case
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int preMin = 0, preSecMin = 0, preMinIdx = -1;
        
        for(int i = 0; i<n; i++){
            int min = Integer.MIN_VALUE, secMin = Integer.MAX_VALUE, minIdx = -1;
            for(int j = 0; j<k; j++){
                int val = costs[i][j] + (preMinIdx == j? preSecMin : preMin);
                
                if(minIdx < 0) {
                    min = val;
                    minIdx = j;
                }else if(val < min){
                    secMin = min;
                    min = val;
                    minIdx = j;
                }else if(val < secMin){
                    secMin = val;
                }
            }
            
            preMin = min;
            preSecMin = secMin;
            preMinIdx = minIdx;
        }
        return preMin;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
