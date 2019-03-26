import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

	class TreeNode {
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

	// recursive solution
	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetricVal(root.left, root.right);
	}

	public static boolean isSymmetricVal(TreeNode leftNode, TreeNode rightNode) {
		if (leftNode == null && rightNode == null)
			return true;
		if (leftNode == null || rightNode == null)
			return false;
		if (leftNode.val == rightNode.val) {
			return isSymmetricVal(leftNode.left, rightNode.right) && isSymmetricVal(leftNode.right, rightNode.left);
		}
		return false;
	}

	// iterative solution
	public static boolean iterativeSym(TreeNode root) {

		Queue<TreeNode> q = new LinkedList<>();

		q.add(root);
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode a = q.poll();
			TreeNode b = q.poll();

			if (a == null && b == null)
				continue;
			if (a == null || b == null)
				return false;
			// System.out.println("a: " + a.val + " b: " + b.val);
			if (a.val != b.val)
				return false;

			q.add(a.left);
			q.add(b.right);
			q.add(a.right);
			q.add(b.left);
		}
		return true;
	}

}
