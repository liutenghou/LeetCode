import java.util.*;

public class FlattenBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void flatten(TreeNode root) {
		if (root == null)
			return;

		TreeNode temp = root;
		List<TreeNode> l = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();

		while (temp != null) {
			System.out.println("adding: " + temp.val);
			l.add(temp);
			if (temp.right != null) {
				stack.push(temp.right);
			}

			temp = temp.left;
			if (temp == null && !stack.empty()) {
				temp = stack.pop();
			}
		}

		root = l.get(0);
		root.left = null;
		TreeNode temp2 = root;
		for (int i = 1; i < l.size(); i++) {
			temp2.right = l.get(i);
			temp2.left = null;
			temp2 = temp2.right;
		}
		temp2.right = null;
	}
	
	public void flattenInPlace(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root;
        
        while(temp != null){
            if(temp.left != null){
                TreeNode left = temp.left; //go left one
                while(left.right != null){
                    left = left.right; //go all the way right
                }
                left.right = temp.right;
                temp.right = temp.left;
                temp.left = null;
                
                
            }
            temp = temp.right;
        }
        
    }

}
