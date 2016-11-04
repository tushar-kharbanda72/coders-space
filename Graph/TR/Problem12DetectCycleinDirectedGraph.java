import java.util.*;

class Graph{
    int maxVertex = 10;
    LinkedList[] adjacencyList;
    int vertexCount;
    public Graph(int vc){
        vertexCount = vc;
        adjacencyList = new LinkedList[vertexCount];
        for(int i=0; i < vertexCount; i++)
            adjacencyList[i] = new LinkedList();
    }
    public void addVertex(int source, int dest){
        adjacencyList[source].add(dest);
    }

    public void print(){
        Iterator it = adjacencyList[2].listIterator(1);
        System.out.println(it.next());
    }

}


class Problem12DetectCycleinDirectedGraph{
    private Set<Integer> whiteSet = new HashSet<>();
    private Set<Integer> greySet = new HashSet<>();
    private Set<Integer> blackSet = new HashSet<>();

    public boolean hasCycle(Graph graph){
        for(int i=0; i<graph.vertexCount; i++){
            whiteSet.add(i);
        }

        while(whiteSet.size() > 0){
            int vertex = whiteSet.iterator().next();
            if(dfs(graph, vertex)){
                return true;
            }
        }
        return false;
    }

    public boolean dfs(Graph g, int vertex){
        moveVertexWTG(vertex);
        Iterator it = g.adjacencyList[vertex].listIterator(0);
        while(it.hasNext()){
            int v = (int)it.next();
            if(blackSet.contains(v))
                continue;
            if(greySet.contains(v))
                return true;
            if(dfs(g, v))
                return true;
        }
        moveVertexGTB(vertex);
        return false;
    }

    public void moveVertexWTG(int vertex){
        whiteSet.remove(vertex);
        greySet.add(vertex);
    }

    public void moveVertexGTB(int vertex){
        greySet.remove(vertex);
        blackSet.add(vertex);
    }
    public static void main(String[] args){
        Problem12DetectCycleinDirectedGraph ob = new Problem12DetectCycleinDirectedGraph();
        Graph graph = new Graph(5);
        graph.addVertex(2, 0);
        graph.addVertex(2, 3);
        graph.addVertex(0, 1);
        graph.addVertex(3, 4);
       // graph.addVertex(4, 2);

        System.out.println(ob.hasCycle(graph));
    }
}