
public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = -2147483648;
		System.out.println(reverse(i));
	}
	
public static int reverse(int x) {
        
        
        boolean isNegative = false;
        if(x<0){
            isNegative = true;
            x = -x;
        }
        
        int[] resultsArray = new int[String.valueOf(x).length()];
        int temp = 0;
        
        int i = 0;
        while(x != 0){
            temp = x%10;
            resultsArray[i] = temp;
            x /= 10;
            i++;
        }
        
        int result = 0;
        for(int j=0; j<resultsArray.length; j++){
            //check integer overflow
            long o = (long)resultsArray[j] + (long)result*10;
            result = (int)o;
            if(o != result){
                return 0;
            }
            
            System.out.println("result: " + result + " o: " + o);
        }
        
        if(isNegative){
            result = -result;
        }
        
        return result;
    }

}
