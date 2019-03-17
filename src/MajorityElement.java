import java.util.*;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {3,2,3};
		System.out.println(majorityElement(input));
	}

	public static int majorityElement(int[] nums) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int num : nums) {
			if (!hm.containsKey(num)) {
				hm.put(num, 1);
			} else {
				int val = hm.get(num);
				hm.replace(num, val + 1);
			}
		}

		int maxVal = Integer.MIN_VALUE;
		int maxCount = Integer.MIN_VALUE;

		for (Map.Entry<Integer, Integer> m : hm.entrySet()) {
			int val = m.getKey();
			int count = m.getValue();

			if (count > maxCount) {
				maxVal = val;
				maxCount = count;
			}
		}

		return maxVal;

	}

}
