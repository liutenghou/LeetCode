
public class IslandPerimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// brute force N^2
	public int islandPerimeter(int[][] grid) {

		int perimeter = 0;

		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				if (grid[y][x] == 1)
					perimeter += islandHelper(grid, x, y);
			}
		}

		return perimeter;
	}

	public int islandHelper(int[][] grid, int x, int y) {
		int sum = 0;

		// left
		if (x - 1 < 0) {
			sum++;
		} else {
			if (grid[y][x - 1] == 0) {
				sum++;
			}
		}

		// right
		if (x + 1 > grid[y].length - 1) {
			sum++;
		} else {
			if (grid[y][x + 1] == 0) {
				sum++;
			}
		}

		// top
		if (y - 1 < 0) {
			sum++;
		} else {
			if (grid[y - 1][x] == 0) {
				sum++;
			}
		}

		// bottom
		if (y + 1 > grid.length - 1) {
			sum++;
		} else {
			if (grid[y + 1][x] == 0) {
				sum++;
			}
		}

		return sum;
	}

}
