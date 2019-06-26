
public class SubtreeOfAnotherTree {

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

	public boolean isSubtree(TreeNode s, TreeNode t) {
		boolean curr = false;
		boolean left = false;
		boolean right = false;
		if (s != null) {
			curr = isSubHelper(s, t);
		}
		if (s.left != null) {
			left = isSubtree(s.left, t);
		}
		if (s.right != null) {
			right = isSubtree(s.right, t);
		}

		if (curr || left || right)
			return true;
		return false;
	}

	public boolean isSubHelper(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;
		if (s == null || t == null)
			return false;

		boolean left = true;
		if (s.left != null && t.left != null) {
			left = isSubHelper(s.left, t.left);
		} else if (s.left == null && t.left == null) {
			left = true;
		} else if (s.left == null || t.left == null) {
			left = false;
		}

		boolean right = true;
		if (s.right != null && t.right != null) {
			right = isSubHelper(s.right, t.right);
		} else if (s.right == null && t.right == null) {
			right = true;
		} else if (s.right == null || t.right == null) {
			right = false;
		}

		boolean curr = true;
		if (s.val != t.val)
			curr = false;

		if (left && right && curr)
			return true;
		return false;
	}

}
