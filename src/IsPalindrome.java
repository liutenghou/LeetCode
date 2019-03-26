import java.util.Stack;

public class IsPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isPalindrome(int x) {
        char[] nums = Integer.toString(x).toCharArray();
        
        int numlength = nums.length;
        int halflength = numlength/2;
        
        Stack<Character> s = new Stack<>();
        
        for(int i=0; i<numlength; i++){
            if(numlength%2 != 0 && i == halflength) continue;
            if(i<halflength){
                s.push(nums[i]);
            }else{
                char c = s.pop();

                if(c != nums[i]){
                    return false;
                }
            }
        }    
        
        return true;
    }

}
