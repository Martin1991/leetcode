
public class ArithmeticSlices_413 {
	
	//solution1
	public static int numberOfArithmeticSlices(int[] A) {
        //base case
        if(A == null || A.length < 3) return 0;
        int cur = 0;
        int res = 0;
        
        for(int i = 2; i<A.length; i++){
            
            if(A[i] - A[i-1] == A[i-1] - A[i-2]) {cur = cur+1; res += cur;}
            else cur = 0;
 
        }
        
        return res;
    }
	
	//solution2
	public static int numberOfArithmeticSlices2(int[] A){
		//base case
		if(A == null || A.length < 3) return 0;
		int[] dp = new int[A.length];
		int res = 0;
		
		for(int i = 2; i<A.length; i++){
			if(A[i] - A[i-1] == A[i-1] - A[i-2]){
				dp[i] = dp[i-1]+1;
			}
			res += dp[i];
		}
		return res;
	}
	
	
	public static void main(String[] args){
		int[] A = {1,2,3,4};
		System.out.println(numberOfArithmeticSlices(A));
	}
	
}
