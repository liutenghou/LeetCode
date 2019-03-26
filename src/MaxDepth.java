
public class MaxDepth {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDepth(TreeNode root) {
		int height = 1;
		if (root == null)
			return 0;
		return max(root.left, root.right, height);
	}

	// 1(1), 3(2), 15(3)
	public int max(TreeNode l, TreeNode r, int i) {
		if (l == null && r == null)
			return i;

		int lval = 0, rval = 0;

		if (l != null) {
			lval = max(l.left, l.right, i + 1);
		}

		if (r != null) {
			rval = max(r.left, r.right, i + 1);
		}

		return Math.max(lval, rval);

	}

}
