import java.util.*;

public class AllSubsetsOfSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(subsetsUnique(new int[]{1,2,2}));

	}
	public static List<List<Integer>> subsetsUnique(int[] nums) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        if(nums.length < 1) return ll;
        
        subsetUniqueHelper(nums, 0, ll, new ArrayList<Integer>());
        
        return ll;
        
    }
    
    public static void subsetUniqueHelper(int[] nums, int ind, List<List<Integer>> ll, List<Integer> l){
        ll.add(new ArrayList(l));
        
        for(int i=ind; i<nums.length; i++){
            l.add(nums[i]);
            subsetUniqueHelper(nums, i+1, ll, l);
            l.remove(l.size()-1);
        }
    }
    
    
    /*------------------------------------------*/
    //with duplicates
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        if(nums.length < 1) return ll;
        Arrays.sort(nums);
        subsetsDubHelper(nums, 0, ll, new ArrayList<Integer>());
        
        return ll;
    }
    
    public void subsetsDubHelper(int[] nums, int ind, List<List<Integer>> ll, ArrayList<Integer> l){
        ll.add(new ArrayList(l));
        
        for(int i=ind; i<nums.length; i++){
            if(i>ind && nums[i] == nums[i-1]) continue;
            l.add(nums[i]);
            subsetsDubHelper(nums, i+1, ll, l);
            l.remove(l.size()-1);
        }
    }
}
