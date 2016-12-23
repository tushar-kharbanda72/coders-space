import java.util.*;
class Rank{
	BST root = null;
	public void insert(int val){
		root = insert(root, val);
	}

	private BST insert(BST n, int data){
		if(n == null)
			return new BST(data);
		if(data == n.val)
			return n;
		if(data > n.val)
			n.right = insert(n.right, data);
		else{
			n.ln++;
			n.left = insert(n.left, data);

		}
		return n;
	}

	public int rank(int k){
		return rank(root, k, 0);
	}
	private int rank(BST n, int k, int total){
		//		System.out.println(n.val);
		if(n == null)
			return -1;
		if(total + n.ln == k)
			return n.val;

		if(total + n.ln <= k){
			return rank(n.right, k, total+n.ln);
		}
		if(total + n.ln > k){
			return rank(n.left, k, total);
		}
		return 100;
	}

	public void inorder(){
		inorder(root);
	}
	private void inorder(BST n){
		if(n == null)
			return;
		inorder(n.left);
		System.out.println(n.ln);
		inorder(n.right);
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Rank ob = new Rank();
		for(int i=1; i<=10; i++){
			ob.insert(in.nextInt());
		}
		//	ob.inorder();
		System.out.println(ob.rank(6));

	}
}
