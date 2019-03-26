import java.util.Arrays;

public class MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void moveZeroes(int[] nums) {
		int numslength = nums.length;
		int zeroindex = -1;

		for (int i = 0; i < numslength; i++) {
			int num = nums[i];

			if (num == 0) {
				if (zeroindex < 0) {
					zeroindex = i;
				}
			} else {
				if (zeroindex >= 0) {
					nums[zeroindex] = num;
					nums[i] = 0;
					zeroindex++;
				}
			}
		}

	}

}
