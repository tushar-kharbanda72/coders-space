public class MinimalTree{

	public Node createTree(int arr[]){
		return createTree(arr, 0, arr.length - 1);
		
	}

	private Node createTree(int[] arr, int left, int right){
		if(left > right)
			return null;
		int mid = (left + right) / 2;
		Node n = new Node(arr[mid]);
		n.left = createTree(arr, left, mid - 1);
		n.right = createTree(arr, mid + 1, right);
		return n;
	}

	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		MinimalTree ob = new MinimalTree();
		Tree t = new Tree();
		t.root = ob.createTree(arr);
		t.print();
}
}
