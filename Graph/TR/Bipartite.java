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
class Bipartite{
    public boolean isBipartite(Graph<Integer> g){
        Set<Vertex<Integer>> redSet = new HashSet<Vertex<Integer>>();
        Set<Vertex<Integer>> blueSet = new HashSet<Vertex<Integer>>();
        for(Vertex<Integer> v: g.getAllVertex()){
            if(redSet.contains(v) || blueSet.contains(v))
                continue;
            boolean flag = isBipartite(v, redSet, blueSet, true);
            if(!flag)
                return false;
        }
        return true;
    }
    private boolean isBipartite(Vertex<Integer> vertex, Set<Vertex<Integer>> redSet, Set<Vertex<Integer>> blueSet, boolean wasRed){
        if(wasRed){
            if(redSet.contains(vertex))
                return false;
            else if(blueSet.contains(vertex))
                    return true;
                blueSet.add(vertex);
        } else{
            if(blueSet.contains(vertex))
                return false;
            else if(redSet.contains(vertex))
                    return true;
            redSet.add(vertex);
        }

        for(Vertex<Integer> v : vertex.allAdjVertex()){
            boolean flag = isBipartite(v, redSet, blueSet, !wasRed);
            if(!flag)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        Graph<Integer> graph = new Graph<Integer>(false);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        Bipartite ob = new Bipartite();
        System.out.println(ob.isBipartite(graph));


    }
}