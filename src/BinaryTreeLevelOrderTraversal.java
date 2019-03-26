import java.util.*;

public class BinaryTreeLevelOrderTraversal {

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
		List<List<Integer>> l = new ArrayList<>();

		levelHelper(root, l);

		return l;
	}

	public void levelHelper(TreeNode root, List<List<Integer>> l) {

	}

}
