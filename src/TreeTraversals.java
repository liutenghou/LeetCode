import java.util.*;

public class TreeTraversals {

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

	// postorder
	// recursive
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> l = new ArrayList<>();
		addToList(root, l);
		return l;
	}

	public void addToList(TreeNode n, List<Integer> l) {
		if (n == null)
			return;

		addToList(n.left, l);
		addToList(n.right, l);
		l.add(n.val);
	}

	// iterative
	public List<Integer> postorderTraversalIterative(TreeNode root) {
		List<Integer> l = new LinkedList<>();
		if (root == null)
			return l;
		Stack<TreeNode> s = new Stack<>();

		s.add(root);

		while (!s.empty()) {
			TreeNode n = s.pop();
			// adds backwards
			l.add(0, n.val);

			if (n.left != null)
				s.add(n.left);
			if (n.right != null)
				s.add(n.right);
		}

		return l;
	}

	// inorder
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> l = new LinkedList<>();
		if (root == null)
			return l;

		inorder(root, l);

		return l;
	}

	public void inorder(TreeNode n, List<Integer> l) {
		if (n.left != null)
			inorder(n.left, l);
		l.add(n.val);
		if (n.right != null)
			inorder(n.right, l);
	}

	// inorder iterative
	public List<Integer> inorderTraversalIterative(TreeNode root) {
		List<Integer> l = new LinkedList<>();
		if (root == null)
			return l;

		Stack<TreeNode> s = new Stack<>();

		while (root != null || !s.empty()) {

			while (root != null) {
				s.push(root);
				root = root.left;
			}

			root = s.pop();
			l.add(root.val);
			root = root.right;
		}

		return l;

	}

	// preorder
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> l = new LinkedList<>();
		if (root == null)
			return l;

		preorderHelper(root, l);

		return l;
	}

	public void preorderHelper(TreeNode node, List<Integer> l) {
		l.add(node.val);
		if (node.left != null)
			preorderHelper(node.left, l);
		if (node.right != null)
			preorderHelper(node.right, l);
	}
}
