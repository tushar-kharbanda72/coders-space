public class Tree{
	public Node root;

	
	public Tree(){
		root = null;
	}
	public void insert(int d){
		root = insert(root, d, null);
	}

	private Node insert(Node n, int d, Node parent){
		if(n == null) return new Node(d, parent);
		if(n.val > d)
			n.left = insert(n.left, d, n);
		else
			n.right = insert(n.right, d, n);
		return n;
	}

	public void print(){
		inorder(root);
	}
	private void inorder(Node n){
		if(n == null) return ;
		inorder(n.left);
		System.out.println(n.val);
		inorder(n.right);
	}
}
class Node{
	int val;
	Node left, right, parent;
	public Node(int val, Node parent){
		this.val = val;
		left = right = null;
		this.parent = parent;
	}
}