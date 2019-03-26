
public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void sortColors(int[] nums) {
		if (nums.length < 2)
			return;

		int[] counts = new int[3];

		for (int i = 0; i < nums.length; i++) {
			int curr = nums[i];
			counts[curr]++;
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < counts.length; j++) {
				if (counts[j] > 0) {
					nums[i] = j;
					counts[j]--;

					break;
				}
			}
		}
	}

}
