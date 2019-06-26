import java.util.*;


public class NaryPreOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//recursive
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	public List<Integer> preorder(Node root) {
        List<Integer> l = new ArrayList<>();
        if(root == null) return l;
        
        preHelper(root, l);
        
        return l;
    }
    
    void preHelper(Node node, List<Integer> l){
        
        l.add(node.val);
        
        for(int i=0; i<node.children.size(); i++){
            preHelper(node.children.get(i), l);
        }
    }
    
    //iterative
    public List<Integer> preorderIterative(Node root) {
        List<Integer> l = new ArrayList<>();
        if(root == null) return l;
        
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.empty()){
            Node cur = s.pop();
            l.add(cur.val);
            for(int i=cur.children.size()-1; i>=0; i--){
                s.push(cur.children.get(i));
            }
        }
        return l;
    }

}
