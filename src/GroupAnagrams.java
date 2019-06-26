import java.util.*;

public class GroupAnagrams {

	//slow
	public List<List<String>> groupAnagramsSlow(String[] strs) {
        List<List<String>> ll = new ArrayList<List<String>>();
        if(strs.length < 1) return ll;
        List<String> l = new ArrayList<>();
        List<String> s = new ArrayList<>(Arrays.asList(strs));
        
        while(s.size() > 0){
            String curr = s.get(0);
            
            for(int j=1; j<s.size(); j++){
                String next = s.get(j);
                if(isAnagram(curr, next)){
                    l.add(next);
                    s.remove(j);
                    j--;
                }
            }
            l.add(curr);
            s.remove(0);
            ll.add(new ArrayList(l));
            l = new ArrayList<>();
        }
        return ll;
    }
    
    boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        int[] s1_i = new int[26];
        int[] s2_i = new int[26];
        for(int i=0; i<s1.length(); i++){
            s1_i[s1.charAt(i) - 'a']++;
            s2_i[s2.charAt(i) - 'a']++;
        }
        for(int i=0; i<s1_i.length; i++){
            if(s1_i[i] != s2_i[i]) {
                return false;
            }
        }
        return true;
    }
	
}
