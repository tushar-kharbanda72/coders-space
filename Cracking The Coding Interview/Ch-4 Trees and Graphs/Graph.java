import java.util.ArrayList;
public class Graph{
    public Node[] nodes;
	private int v;
	public Graph(int v){
		this.v = v;	
		nodes = new Node[v];
		
	}

	public void addEdge(int source, int dest){
		Node a = nodes[source] == null ? (nodes[source] = new Node(source)) : nodes[source];
		Node b = nodes[dest] == null ? (nodes[dest] = new Node(dest)) : nodes[dest];
		nodes[source].addChild(b);
		nodes[dest].addChild(a);
	}

	public Node[] getNodes(){
		return nodes;
	}
}
class Node{
	
	public int val;
	public ArrayList<Node> childNodes;
	
	public Node(int d){
		childNodes = new ArrayList<Node>();
		val = d;
	}

	public void addChild(Node c){
		childNodes.add(c);
	}

	public ArrayList<Node> getChildNodes(){
		return childNodes;
	}
}