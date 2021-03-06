import java.util.*;


class Graph<T>{
    private List<Edge<T>> allEdges;
    private Map<Integer, Vertex<T>> allVertex;
    boolean isDirected = false;

    public Graph(boolean isDirected){
        allEdges = new ArrayList<Edge<T>>();
        allVertex = new HashMap<Integer, Vertex<T>>();
        this.isDirected = isDirected;
    }
    public void addEdge(Integer i1, Integer i2){
        addEdge(i1, i2, 0);
    }

    public void addEdge(Integer id1, Integer id2, int weight){
        Vertex<T> vertex1 = null;
        if(allVertex.containsKey(id1)){
            vertex1 = allVertex.get(id1);
        }else{
            vertex1 = new Vertex<T>(id1);
            allVertex.put(id1, vertex1);
        }

        Vertex<T> vertex2 = null;
        if(allVertex.containsKey(id2)){
            vertex2 = allVertex.get(id2);
        }else{
            vertex2 = new Vertex<T>(id2);
            allVertex.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<T>(vertex1, vertex2, isDirected, weight);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge, vertex1);
        }
    }

    public List<Edge<T>> getAllEdges(){
        return allEdges;
    }

    public Collection<Vertex<T>> getAllVertex(){
        return allVertex.values();
    }
}

class Vertex<T>{
    int id;
    private T data;
    private List<Edge<T>> edges = new ArrayList<Edge<T>>();
    private List<Vertex<T>> adjacentVertex = new ArrayList<Vertex<T>>();

    Vertex(int id){
        this.id = id;
    }

    public void addAdjacentVertex(Edge<T> edge, Vertex<T> vertex){
        edges.add(edge);
        adjacentVertex.add(vertex);
    }
    public int getId(){
        return this.id;
    }
    public List<Vertex<T>> allAdjVertex(){
        return this.adjacentVertex;
    }
}

class Edge<T>{
    private boolean isDirected = false;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;

    Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected, int weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.isDirected = isDirected;
    }

    Vertex<T> getVertex1(){
        return this.vertex1;
    }

    Vertex<T> getVertex2(){
        return this.vertex2;
    }

    int getWeight(){
        return this.weight;
    }
}

public class StronglyConnectedComponents{

    public Graph<Integer> reverseGraph(Graph<Integer> g){
        Graph<Integer> rg = new Graph<>(true);
        for(Edge<Integer> e:g.getAllEdges()){
            rg.addEdge(e.getVertex2().getId(), e.getVertex1().getId(), e.getWeight());
        }
        return rg;
    }
    public void dfs(Graph<Integer> g){
        Set<Vertex<Integer>> visited = new HashSet<Vertex<Integer>>();
        for(Vertex<Integer> v: g.getAllVertex()){
            if(!visited.contains(v)){
                dfsUtil(v, visited);
            }
        }
    }
    private void dfsUtil(Vertex<Integer> v, Set<Vertex<Integer>> visited){
        visited.add(v);

        for(Vertex<Integer> vert: v.allAdjVertex()){
            if(!visited.contains(vert)){
                dfsUtil(vert, visited);
            }
        }
        System.out.println(v.getId());
    }
    public static void main(String[] args){
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        StronglyConnectedComponents ob = new StronglyConnectedComponents();
        Graph<Integer> reversedGraph = new Graph<>(true);
        reversedGraph = ob.reverseGraph(graph);
        ob.dfs(graph);
        ob.dfs(reversedGraph);
        System.out.println(graph.isDirected);
        System.out.println(reversedGraph.isDirected);


    }
}