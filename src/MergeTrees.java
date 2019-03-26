
public class MergeTrees {

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

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return null;

		TreeNode merged = new TreeNode(0);

		if (t1 == null) {
			merged.val = t2.val;
			merged.left = t2.left;
			merged.right = t2.right;
		} else if (t2 == null) {
			merged.val = t1.val;
			merged.left = t1.left;
			merged.right = t1.right;
		} else {
			merged.val = t1.val + t2.val;
			merged.left = mergeTrees(t1.left, t2.left);
			merged.right = mergeTrees(t1.right, t2.right);
		}
		return merged;
	}

}
