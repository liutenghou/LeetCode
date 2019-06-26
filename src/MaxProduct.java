
public class MaxProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProduct(int[] nums) {
		if (nums.length < 1)
			return 0;

		int biggest = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int currentSum = nums[i];
			for (int j = i; j < nums.length; j++) {
				if (i != j)
					currentSum *= nums[j];
				if (currentSum > biggest)
					biggest = currentSum;
			}
		}

		return biggest;
	}

	// O(N) solution, look over again

	class Memo {
		int minmo;
		int maxmo;

		Memo(int minmo, int maxmo) {
			this.minmo = minmo;
			this.maxmo = maxmo;
		}
	}

	public int maxProductLinear(int[] nums) {
		if (nums.length < 1)
			return 0;

		Memo[] memo = new Memo[nums.length];
		memo[0] = new Memo(nums[0], nums[0]);

		int max, min;
		int result = memo[0].maxmo;

		for (int i = 1; i < nums.length; i++) {
			int minpre = memo[i - 1].minmo;
			int maxpre = memo[i - 1].maxmo;
			int curr = nums[i];

			if (curr * minpre < curr * maxpre) {
				min = curr * minpre;
			} else {
				min = curr * maxpre;
			}
			if (curr < min)
				min = curr;

			if (curr * maxpre > curr * minpre) {
				max = curr * maxpre;
			} else {
				max = curr * minpre;
			}
			if (curr > max)
				max = curr;

			memo[i] = new Memo(min, max);

			// global max result;
			if (max > result)
				result = max;
		}

		return result;
	}

}
