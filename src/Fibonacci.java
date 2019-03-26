import java.util.HashMap;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib(37));
	}
	
	//memo
    static HashMap<Integer, Integer> hm = new HashMap<>();
    
    public static int fib(int N) {
        if(N < 2) return N;
        
        if(hm.containsKey(N)) return hm.get(N);
        
        int result = fib(N-1) + fib(N-2);
        hm.put(N, result);
        
        return result;
    }

}
