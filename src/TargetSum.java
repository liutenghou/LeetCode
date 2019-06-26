
public class TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findTargetSumWays(int[] nums, int S) {
        if(nums.length < 1 || nums == null) return 0;
        
        return findHelper(nums, 0, 0, S);
    }
    
    int findHelper(int[] nums, int cur, int ind, int S){
        if(ind == nums.length){
            if(cur == S) return 1;
            return 0;
        }
        
        return findHelper(nums, cur+nums[ind], ind+1, S) + findHelper(nums, cur-nums[ind], ind+1, S);
    }
    
    //memoized
    public int findTargetSumWaysMemo(int[] nums, int S) {
        if(nums.length < 1 || nums == null) return 0;
        
        int[][] memo = new int[nums.length][2000];
        for(int i=0; i<memo.length; i++){
            for(int j=0; j<memo[i].length; j++){
                memo[i][j] = Integer.MIN_VALUE;
            }
        }
        return findHelperMemo(nums, 0, 0, S, memo);
    }
    
    int findHelperMemo(int[] nums, int cur, int ind, int S, int[][] memo){
        if(ind == nums.length){
            if(cur == S) return 1;
            return 0;
        }
        
        int sum;
        if(memo[ind][cur+1000] == Integer.MIN_VALUE){
            memo[ind][cur+1000] = findHelperMemo(nums, cur+nums[ind], ind+1, S, memo) + findHelperMemo(nums, cur-nums[ind], ind+1, S, memo);
            sum = memo[ind][cur+1000];
        }else{
            sum = memo[ind][cur+1000];
        }
        return sum;
    }

}
