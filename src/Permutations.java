import java.util.*;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        if(nums.length < 1) return ll;
        permuteHelper(nums, ll, new ArrayList<Integer>());
        return ll;
    }
    
    public void permuteHelper(int[] nums, List<List<Integer>> ll, List<Integer> l){
        if(l.size() == nums.length) {
            ll.add(new ArrayList(l));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(l.contains(nums[i])) continue;
            l.add(nums[i]);
            permuteHelper(nums, ll, l);
            l.remove(l.size()-1);
        }
    }
    
    //permutations with duplicates, slow
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        if(nums.length<1) return ll;
        boolean[] used = new boolean[nums.length];
        permuteUniqueHelper(nums, ll, new ArrayList<Integer>(), used);
        
        return ll;
    }
    
    public void permuteUniqueHelper(int[] nums, List<List<Integer>> ll, List<Integer> l, boolean[] used){
        if(!ll.contains(l) && l.size() == nums.length){
            ll.add(new ArrayList(l));
            return;
        } 
        
        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;
            l.add(nums[i]);
            used[i] = true;
            permuteUniqueHelper(nums, ll, l, used);
            l.remove(l.size()-1);
            used[i] = false;
        }
    }
    
    //permutations with duplicates, fast
    public List<List<Integer>> permuteUniqueFast(int[] nums) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        if(nums.length<1) return ll;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUniqueHelper(nums, ll, new ArrayList<Integer>(), used);
        
        return ll;
    }
    
    public void permuteUniqueFastHelper(int[] nums, List<List<Integer>> ll, List<Integer> l, boolean[] used){
        if(l.size() == nums.length){
            ll.add(new ArrayList(l));
            return;
        } 
        
        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;
            if(i>0 && !used[i-1] && nums[i] == nums[i-1]) continue;
            l.add(nums[i]);
            used[i] = true;
            permuteUniqueHelper(nums, ll, l, used);
            l.remove(l.size()-1);
            used[i] = false;
        }
    }

}
