import java.util.*;

public class FindCommonCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        if(A.length<1) return result;
        if(A.length == 1) return new ArrayList<>(Arrays.asList(A[0]));
        
        int[] temp = new int[26];
        for(int i=0; i<A[0].length(); i++){
            temp[A[0].charAt(i)-'a']++;
        }
        
        for(int i=1; i<A.length; i++){
            
            int[] current = new int[26];
            for(int j=0; j<A[i].length(); j++){
                current[A[i].charAt(j) - 'a']++;
            }
            
            for(int j=0; j<temp.length; j++){
                if(current[j] < temp[j]) temp[j] = current[j];
            }
            
        }
        
        for(int i=0; i<temp.length; i++){
            int c = temp[i];
            if(c>0){
                for(int j=0; j<c; j++){
                    result.add(Character.toString((char)('a' + i)));
                }
            }
        }
                       
        return result;
    }
}
