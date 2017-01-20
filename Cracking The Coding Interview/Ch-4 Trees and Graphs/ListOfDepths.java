import java.util.*;
public class ListOfDepths{

	// Solution using dfs
	public ArrayList<LinkedList<Node>> createLevelLinkedList(Tree t){
		
		ArrayList<LinkedList<Node>> list = new ArrayList<LinkedList<Node>>();
		createLevelLinkedList(t.root, list, 0);	
		return list;	
	}

	private void createLevelLinkedList(Node n, ArrayList<LinkedList<Node>> list, int level){
		if(n == null) return;

		LinkedList<Node> l;
		if(level == list.size()){
			l = new LinkedList<Node>();
			list.add(l);
		}else{
			l = list.get(level);
		}
		l.add(n);
		createLevelLinkedList(n.left, list, level + 1);
		createLevelLinkedList(n.right, list, level + 1);

	}

	// Solution using bfs
	public ArrayList<LinkedList<Node>> createLevelLinkedList2(Tree t){
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		
	}
	

		

	public static void main(String[] args){
		Tree t = new Tree();
		Scanner in = new Scanner(System.in);
		for(int i=0; i<10; i++){
			t.insert(in.nextInt());
		}
		ListOfDepths ob = new ListOfDepths();
		ArrayList<LinkedList<Node>> list = ob.createLevelLinkedList(t);
		for(int i=0; i<list.size(); i++){
			Iterator it = list.get(i).listIterator();
			while(it.hasNext()){
				Node n = (Node)it.next();
				System.out.print(n.val + " ");
			}
			System.out.println();
		}
	}
}