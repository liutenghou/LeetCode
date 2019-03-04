import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test = "()";
		System.out.println(isValid(test));
	}

	public static boolean isValid(String input) {
        
        Stack<Character> s = new Stack<>();
        
        for(char c: input.toCharArray()){
            
            if(s.empty()){
                s.push(c);
                continue;
            }
            //can also optimize here by checking if first bracket is a closing one
            //if true, return false
            
            //lefts
            if(c == '{' || c == '[' || c == '('){
                s.push(c);
            }else{
                char top = s.peek();
                //right matches
                if(c == ')'){
                    if(top == '('){
                        s.pop();
                    }else{
                        s.push(c);
                    }
                }
                if(c == '}'){
                    if(top == '{'){
                        s.pop();
                    }else{
                        s.push(c);
                    }
                }
                if(c == ']'){
                    if(top == '['){
                        s.pop();
                    }else{
                        s.push(c);
                    }
                }
            }
        }
        
        if(s.empty() == true){
            return true;
        }
        
        return false;
    }

}
