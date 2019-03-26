import java.util.HashMap;

public class ClimbStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairsMemoed(40));
	}
	
	//O(2^n)
	public static int climbStairs(int n) {
        //tail recursive brute force approach
        
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        return climbStairs(n-1) + climbStairs(n-2);
    }
	
	//with memoization
	public static int climbStairsMemoed(int n) {
        int[] memo = new int[n];
        return climbStairsMemo(n, 0, memo);
    }
    
    public static int climbStairsMemo(int n, int i, int[] memo){
        if(i == n) return 1;
        if(i == (n-2)) return 2;
        if(i>n) return 0;
        
        if(memo[i] > 0) return memo[i];
        
        memo[i] = climbStairsMemo(n, i+1, memo) + climbStairsMemo(n, i+2, memo);
        return memo[i];
    }
    
    //version 2
    public int climbStairs2(int n) {
        return climbHelper2(0, n);
    }
    
    HashMap<Integer, Integer> hm = new HashMap<>();
    public int climbHelper2(int i, int n){
        if(i>n) return 0;
        if(i==n) return 1;
        if(hm.containsKey(i)) return hm.get(i);
        
        int result = climbHelper2(i+1, n) + climbHelper2(i+2, n);
        hm.put(i, result);
        
        return result;
    }

}
