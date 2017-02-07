import java.util.Scanner;
class DiameterBinaryTree{

	public int diameter(Node n){
		if(n == null)
			return 0;
		int leftHeight = getHeight(n.left);
		int rightHeight = getHeight(n.right);
		int leftDiamter = diameter(n.left);
		int rightDiamter = diameter(n.right);

		return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiamter, rightDiamter));
	}

	private int getHeight(Node n){
		if(n == null)
			return 0;
		return 1 + Math.max(getHeight(n.left), getHeight(n.right));
	}

	public static void main(String[] args){
		int[] arr = {10, 5, 15, 3, 13, 8, 18, 30};
		Scanner in = new Scanner(System.in);
		Tree t = new Tree();
		for(int i=0; i<arr.length; i++){
			t.insert(arr[i]);
		}
		DiameterBinaryTree ob = new DiameterBinaryTree();
		System.out.println(ob.diameter(t.root));
	}
}