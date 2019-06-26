
public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void rotate(int[][] matrix) {

		rotateHelper(matrix, 0, matrix.length - 1);
	}

	public void rotateHelper(int[][] matrix, int starti, int endi) {
		/*
		 * j=0,1,2 i=0: [1,2,3], i=1: [4,5,6], i=2: [7,8,9]
		 */
		int temp = 0;
		int temp2 = 0;
		int mi = endi;
		for (int i = starti; i < mi; i++) {
			temp = matrix[i][mi];
			matrix[i][mi] = matrix[starti][i];

			temp2 = matrix[mi][mi - (i - starti)];
			matrix[mi][mi - (i - starti)] = temp;
			temp = temp2;

			temp2 = matrix[mi - (i - starti)][starti];
			matrix[mi - (i - starti)][starti] = temp;
			temp = temp2;

			matrix[starti][i] = temp;
		}

		if (starti + 1 < endi - 1) {
			rotateHelper(matrix, starti + 1, endi - 1);
		}
	}

}
