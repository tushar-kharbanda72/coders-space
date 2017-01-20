// Problem 4.6 - find the next inorder successor.

import java.util.*;
class Successor{

	public Integer findInorder(Node n, int d){
		if(n == null)
			return null;
		if(n.val == d)
			return findSuccessor(n);
		if(n.val > d)
			return findInorder(n.left, d);
		return findInorder(n.right, d);

	}




	private Integer findSuccessor(Node n){
		if(n == null)
			return null;
		if(n.right != null){
			return leftMost(n.right).val;
		}else{
			Node p = n;
			Node q = n.parent;
			while(q!= null && q.left != p){
				p = q;
				q = q.parent;
			}
			if(q != null)
				return q.val;
		}
		return null;
	}

	private Node leftMost(Node n){
		if(n == null)
			return null;
		if(n.left == null)
			return n;
		return leftMost(n.left);
	}

	public static void main(String[] args){
		Successor ob = new Successor();
		Tree t = new Tree();
		Scanner in = new Scanner(System.in);
		for(int i=0; i<10; i++)
			t.insert(in.nextInt());
		
		System.out.println(ob.findInorder(t.root, in.nextInt()));
	}

}