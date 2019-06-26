import java.util.*;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        if(candidates.length < 1) return ll;
        Arrays.sort(candidates);
        combinationHelper(candidates, target, ll, new ArrayList(), 0);
        return ll;
    }
    
    public void combinationHelper(int[] nums, int target, List<List<Integer>> ll, List<Integer> l, int start){
        if(target == 0) {
            ll.add(new ArrayList(l));
            return;
        } else if(target < 0) {
            return;
        }
        
        for(int i=start; i<nums.length; i++){
            l.add(nums[i]);
            combinationHelper(nums, target-nums[i], ll, l, i);
            l.remove(l.size()-1);
        }
    }
    
    //can't use number twice
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        if(candidates.length < 1) return ll;
        
        //scrub candidates
        Arrays.sort(candidates);
        List<Integer> nums = new ArrayList<Integer>();
        for(int i: candidates){
            if(i<=target) nums.add(i);
        }
        
        combinationSum2Helper(nums, 0, target, ll, new ArrayList());
        
        return ll;
    }
    
    public void combinationSum2Helper(List<Integer> nums, int start, int target, List<List<Integer>> ll, List<Integer> l){
        if(target == 0){
            ll.add(new ArrayList(l));
            return;
        }else if(target<0){
            return;
        }
        
        for(int i=start; i<nums.size(); i++){
            if(i!=start && i > 0 && nums.get(i) == nums.get(i-1)) continue;
            l.add(nums.get(i));
            combinationSum2Helper(nums, i+1, target-nums.get(i), ll, l);
            l.remove(l.size()-1);
        }
    }

}
