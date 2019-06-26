import java.util.Stack;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Time Limit Exceeds
	public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        
        String result = "";
        int size = Integer.MIN_VALUE;
        
        for(int i=0; i<s.length(); i++){
            for(int j=s.length(); j>i && j>size; j--){
                String r = checkPalindrome(s.substring(i, j));
                
                if(!r.isEmpty()){
                    if(r.length() >= size) {
                        result = r;
                        size = r.length();
                        continue;
                    }
                }
                
            }
        }
        
        return result;
    }
    
    public String checkPalindrome(String s){
        
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int length = c.length;
        
        int middle = length/2;
        for(int i=0; i<length; i++){
            if(i == middle && length%2 != 0) continue;
            if(i<middle){
                stack.push(c[i]);
            }else{
                char popchar = stack.pop();
                if(popchar != c[i]) return "";
            }
        }
        
        return s;
    }

}
