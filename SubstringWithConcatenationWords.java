import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubstringWithConcatenationWords {
	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        
        int l = words[0].length();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<words.length; i++){
        	if(!map.containsKey(words[i])){
        		map.put(words[i], 0);
        	}
            map.put(words[i], map.get(words[i])+1);
        }
        int start = 0, end = 0, counter = words.length;
        
        while(end+l <= s.length()){
            
            if(map.containsKey(s.substring(end, end+l)) && map.get(s.substring(end, end+l)) > 0) {
                counter--;
                map.put(s.substring(end, end+l), map.get(s.substring(end, end+l))-1);
                
            }else {
            	if(map.containsKey(s.substring(end, end+l)) && map.get(s.substring(end, end+l)) == 0) {
            		end -= l; 
            		//counter++;
            		//map.put(s.substring(end, end+l), map.get(s.substring(end, end+l))-1);
            		}
                while(counter < words.length){
                	String temp = s.substring(start, start+l);
                	
                    if(map.containsKey(s.substring(start, start+l))){
                        counter++;
              
                        map.put(s.substring(start, start+l), map.get(s.substring(start, start+l))+1);   
                    }start += l;
                    //map.get("good");
                    
                }
                //end -= l;
            }
            end += l;
            
            while(counter == 0){
                //System.out.println(start);
                //System.out.println(start);
                if(map.containsKey(s.substring(start, start+l)) && map.get(s.substring(start, start+l)) == 0){
                    res.add(start);
                    counter++;
                    map.put(s.substring(start, start+l), map.get(s.substring(start, start+l))+1);
                }start += l;
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "barfoofoobarthefoobarman";
		String[] arr = {"bar","foo","the"};
//		String s = "wordgoodgoodgoodbestword";
//		String[] arr = {"word","good","best","good"};
		List<Integer> res = findSubstring(s, arr);
		for(int x : res){
			System.out.println(x);
		}
		
		

	}

}
