import java.util.*;

public class DissapearedNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDisappearedNumbersFast(nums));
	}

	//O(n) space n
	public static List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> l = new ArrayList<>();
		Set<Integer> s = new HashSet<>();

		for (int n : nums) {
			s.add(n);
		}

		for (int i = 1; i < nums.length + 1; i++) {
			if (!s.contains(i)) {
				l.add(i);
			}
		}

		return l;
	}
	
	//math trick
	public static List<Integer> findDisappearedNumbersFast(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        System.out.println(Arrays.toString(nums));
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
	
	

}
