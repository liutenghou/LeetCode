import java.util.*;

public class LevelOrderTraversal {

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

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();

		levelHelper(root, ll, 0);

		return ll;
	}

	public void levelHelper(TreeNode node, List<List<Integer>> ll, int level) {
		if (node == null)
			return;

		if (ll.size() - 1 < level) {
			List<Integer> l = new ArrayList<>();
			ll.add(l);
		}

		List<Integer> l = ll.get(level);
		l.add(node.val);

		if (node.left != null)
			levelHelper(node.left, ll, level + 1);
		if (node.right != null)
			levelHelper(node.right, ll, level + 1);
	}

}
