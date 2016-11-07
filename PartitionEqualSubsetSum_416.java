import java.util.HashMap;
import java.util.Map;


public class PartitionEqualSubsetSum_416 {
	//DP Time O(n*sum/2), Space O(sum/2);
	public static boolean canPartition(int[] nums) {
        //base case
        if(nums == null || nums.length <= 1) return false;
        
        //get sum
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        sum /= 2;
        
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int j = 0; j<nums.length; j++){
            for(int i = dp.length-1; i>=nums[j]; i--){
                if(dp[i] != false) continue;
                
                dp[i] = dp[i] || dp[i-nums[j]];
                
                
            }
        }
        return dp[dp.length-1];
    }
	
	//dfs with memorization
	private static boolean canPartition2(int[] nums){
		if(nums == null || nums.length <= 1) return false;
		int sum = 0;
		for(int num : nums) sum += num;
		if(sum % 2 != 0) return false;
		sum /= 2;
		return dfs(nums, sum , new HashMap<Integer, Boolean>(), 0);
		
	}
	private static boolean dfs(int[] nums, int sum, Map<Integer, Boolean> map, int pos){
		if(map.containsKey(sum)) map.get(sum);
		
		if(sum == 0) return true;
		else if(sum < 0) return false;
		
		for(int i = pos; i<nums.length; i++){
			if(dfs(nums, sum-nums[i] , map, i+1)){
				map.put(sum, true);
				return true;
			}else map.put(sum, false);
		}
		return false;
	}
	
	
	public static void main(String[] args){
		int[] nums = {1,5,11,5};
		canPartition2(nums);
		//System.out.println(canPartition(nums));
	}
}
