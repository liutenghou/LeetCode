import java.util.*;

public class PascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<Integer>();

		list.add(0, 2);
		list.add(0, 4);
		System.out.println(list);

//		System.out.println(getRowWorks(29));
	}

	// **************
	// how does list(set(x, list.get(x)
	public static List<Integer> getRowWorks(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		if (rowIndex < 0)
			return list;

		for (int i = 0; i < rowIndex + 1; i++) {
			list.add(0, 1);
			for (int j = 1; j < list.size() - 1; j++) {
				System.out.println(list.get(j));
				list.set(j, list.get(j) + list.get(j + 1));
			}
		}
		return list;
	}
	// ******************

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();

		for (int i = 1; i <= numRows; i++) { // i row
			List<Integer> l = new ArrayList<>();
			for (int j = 1; j <= i; j++) { // j column
				if (j == 1 || j == i) {
					l.add(1);
				} else {
					l.add(ll.get(i - 1 - 1).get(j - 1 - 1) + ll.get(i - 1 - 1).get(j - 1));
				}
			}
			ll.add(l);
		}

		return ll;
	}

	// time limit exceeded, get rows (29)
	public List<Integer> getRow(int rowIndex) {
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i <= rowIndex; i++) {
			if (i == 0 || i == rowIndex) {
				l.add(1);
			} else {
				l.add(rowHelper(i - 1, rowIndex - 1) + rowHelper(i, rowIndex - 1));
			}
		}
		return l;
	}

	public int rowHelper(int column, int row) {
		if (column == 0 || row == column)
			return 1;
		return rowHelper(column - 1, row - 1) + rowHelper(column, row - 1);
	}

	// somehow even slower (14)
	List<List<Integer>> ll = new ArrayList<List<Integer>>();

	public List<Integer> getRow2(int rowIndex) {
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i <= rowIndex; i++) {
			if (i == 0 || i == rowIndex) {
				l.add(1);
			} else {
				l.add(rowHelper(i - 1, rowIndex - 1) + rowHelper(i, rowIndex - 1));
			}
		}
		return l;
	}

	public int rowHelper2(int column, int row) {
		if (column == 0 || row == column)
			return 1;

		int left = 0;
		if (ll.contains(column - 1) && ll.get(column - 1).contains(row - 1)) {
			left = ll.get(column - 1).get(row - 1);
		} else if (ll.contains(column - 1) && !ll.get(column - 1).contains(row - 1)) {
			ll.get(column - 1).add(row - 1);
			left = rowHelper(column - 1, row - 1);
		} else if (!ll.contains(column - 1)) {
			ll.add(column - 1, new ArrayList<Integer>());
			ll.get(column - 1).add(row - 1);
			left = rowHelper(column - 1, row - 1);
		}

		int right = 0;
		if (ll.contains(column) && ll.get(column).contains(row - 1)) {
			right = ll.get(column).get(row - 1);
		} else if (ll.contains(column) && !ll.get(column).contains(row - 1)) {
			ll.get(column).add(row - 1);
			right = rowHelper(column, row - 1);
		} else if (!ll.contains(column)) {
			ll.add(column, new ArrayList<Integer>());
			ll.get(column).add(row - 1);
			right = rowHelper(column, row - 1);
		}

		return left + right;
	}
}
