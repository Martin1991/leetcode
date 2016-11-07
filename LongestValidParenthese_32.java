import java.util.Stack;


public class LongestValidParenthese_32 {
	//dp
	public static int longestValidParentheses(String s) {
        //base case
        if(s == null || s.length() <= 1) return 0;
        
        int[] dp = new int[s.length()];
        int max = 0;
        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = i-2 >= 0? (dp[i-2] + 2) : 2;
                    
                }else{
                    if(i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '('){
                        dp[i] = dp[i-1]+2 + ((i-dp[i-1]-2>=0)?dp[i-dp[i-1]-2]:0);
                        
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
	
	//stack
	public static int longestValidParentheses2(String s){
		//base case
		if(s == null || s.length() == 0) return 0;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i<s.length(); i++){
			if(s.charAt(i) == ')'){
				if(!stack.isEmpty() && s.charAt(stack.peek()) == '('){
					stack.pop();
				}else stack.push(i);
			}else stack.push(i);
		}
		int res = 0;
		if(stack.isEmpty()) res = s.length();
		else{
			int a = s.length(), b = 0;
			while(!stack.isEmpty()){
				b = stack.pop();
				res = Math.max(res, a-b-1);
				a = b;
			}
			res = Math.max(res, a);
		}
		return res;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
