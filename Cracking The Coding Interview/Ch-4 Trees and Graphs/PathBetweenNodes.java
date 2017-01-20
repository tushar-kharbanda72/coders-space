import java.util.*;
public class PathBetweenNodes{
	enum state {visited, unvisited, visiting}
	public boolean search(Graph g, int a, int b){
		if(a == b)
			return true;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(g.nodes[a]);
		/*for(Node u = g.getNodes()){
			u.Status = unvisited;
		}*/
		Node n;
		while(!q.isEmpty()){
			n = q.poll();
			if(n.val == b)
				return true;
			n.state = visiting;
			for(Node node : n.getChildNodes()){
				if(node.state == unvisited){
					q.offer(node);
					node.state = visiting;
				}
			}
			n.state = visited;
			}

			
		}

	

	public static void main(String[] args){
		Graph g = new Graph(5);
		PathBetweenNodes ob = new PathBetweenNodes();
		Scanner in = new Scanner(System.in);
		for(int i=0; i<5; i++)
			g.addEdge(in.nextInt(), in.nextInt());
		System.out.println(ob.search(g, in.nextInt(), in.nextInt()));
	}
}