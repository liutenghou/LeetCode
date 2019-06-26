import java.util.*;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// n^4. Time limit exceeds
	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> ll = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					if (sum == 0) {
						List<Integer> l = new ArrayList<>();
						l.add(nums[i]);
						l.add(nums[j]);
						l.add(nums[k]);
						Collections.sort(l);
						if (!ll.contains(l))
							ll.add(l);
					}
				}
			}
		}

		return ll;
	}

	//a slightly better solution O(N^2)
	public List<List<Integer>> threeSumNSquared(int[] nums) {

		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		if (nums.length < 3)
			return ll;

		Arrays.sort(nums);
		int prev = nums[0];
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0) {
				if (nums[i] == prev) {
					continue;
				} else {
					prev = nums[i];
				}
			}

			int prevj = nums[i + 1];
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (j != i + 1) {
					if (nums[j] == prevj) {
						continue;
					} else {
						prevj = nums[j];
					}
				}

				int valueForZero = -(nums[i] + nums[j]);
				int lasti = Arrays.binarySearch(nums, j + 1, nums.length, valueForZero);
				if (lasti < 0)
					continue;

				int lastval = nums[lasti];
				List<Integer> l = new ArrayList<>();
				l.add(nums[i]);
				l.add(nums[j]);
				l.add(lastval);
				ll.add(l);
			}
		}

		return ll;
	}

}
