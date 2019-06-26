
public class FloodFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] floodFill(int[][] image, int x, int y, int newColor) {

		if (image[x][y] != newColor) {
			int cur = image[x][y];
			int[][] touched = new int[image.length][image[x].length];
			touched[x][y] = 1;
			image[x][y] = newColor;
			floodHelper(image, x, y, cur, newColor, touched);
		}

		return image;
	}

	public void floodHelper(int[][] image, int x, int y, int cur, int newColor, int[][] touched) {

		if (x - 1 >= 0 && touched[x - 1][y] == 0) {
			touched[x - 1][y] = 1;
			int left = image[x - 1][y];

			if (left == cur) {
				image[x - 1][y] = newColor;
				floodHelper(image, x - 1, y, cur, newColor, touched);
			}
		}

		if (x + 1 < image.length && touched[x + 1][y] == 0) {
			touched[x + 1][y] = 1;
			int right = image[x + 1][y];

			if (right == cur) {
				image[x + 1][y] = newColor;
				floodHelper(image, x + 1, y, cur, newColor, touched);
			}
		}

		if (y - 1 >= 0 && touched[x][y - 1] == 0) {
			touched[x][y - 1] = 1;
			int up = image[x][y - 1];

			if (up == cur) {
				image[x][y - 1] = newColor;
				floodHelper(image, x, y - 1, cur, newColor, touched);
			}
		}

		if (y + 1 < image[x].length && touched[x][y + 1] == 0) {
			touched[x][y + 1] = 1;
			int down = image[x][y + 1];

			if (down == cur) {
				image[x][y + 1] = newColor;
				floodHelper(image, x, y + 1, cur, newColor, touched);
			}
		}

	}

}
