public class solution{
	public List<List<Stirng>> partition(String s){
		List<List<String>> res = new ArrayList<>();
		if(s == null || s.length == 0) return res;
		
		dfs(s, 0, new ArrayList<>(), res);
		return res;
	}
	
	private void dfs(String s, int pos, List<String> temp, List<List<String>> res){
		if(pos == s.length()){
			res.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i = pos+1; i <= s.length(); i++){
			String str = s.substring(pos, i);
			
			if(!isPal(str)) continue;
			temp.add(str);
			dfs(s, i, temp, res);
			temp.remove(temp.size()-1);
		}
	}
	
	private boolean isPal(String str){
		int l = 0, r = str.length()-1;
		while(l < r){
			if(str.charAt(l) != str.charAt(r)) return false;
			l++;
			r--;
		}
		return true;
	}
}