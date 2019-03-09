import java.util.HashSet;
import java.util.Iterator;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t1 = {4,1,2,1,2};
		System.out.println(singleNumber(t1));
	}

	public static int singleNumber(int[] nums) {
		HashSet<Integer> hs = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (!hs.contains(nums[i])) {
				hs.add(nums[i]);
			} else {
				hs.remove(nums[i]);
			}
		}

		Iterator i = hs.iterator();
		int result = 0;
		while (i.hasNext()) {
			result = (Integer) i.next();
		}
		return result;
	}

}
