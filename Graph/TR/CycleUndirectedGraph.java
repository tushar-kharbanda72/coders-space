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
    public void addEdge(Integer id1, Integer id2){
        addEdge(id1, id2, 0);
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
    public List<Vertex<T>> getAdjVertexes(){
        return adjacentVertex;
    }

    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex)obj;
        if(this.id != other.id)
            return false;
        return true;

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
class Problem5DisjointSets{
    private Map<Integer, Node> map = new HashMap<>();
    class Node{
        int data;
        int rank;
        Node parent;
    }

    /**
     * Create a set with only one element.
     */
    public void makeSet(int number){
        Node n = new Node();
        n.data = number;
        n.rank = 0;
        n.parent = n;
        map.put(number, n);
    }

    /**
     * Combines two sets together to one.
     * Does union by rank
     *
     * @return true if data1 and data2 are in different set before union else false.
     */
    public boolean union(int a, int b){
        Node n1 = map.get(a);
        Node n2 = map.get(b);

        Node parent1 = findSet(n1);
        Node parent2 = findSet(n2);

         //if they are part of same set do nothing
        if(parent1.data == parent2.data)
            return false;

        //else whoever's rank is higher becomes parent of other
        if(parent1.rank >= parent2.rank){
             //increment rank only if both sets have same rank
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        }else{
            parent1.parent = parent2;
        }
        return true;
    }
     /**
     * Finds the representative of this set
     */
    public int findSet(int a){
        return findSet(map.get(a)).data;
    }

    /**
     * Find the representative recursively and does path
     * compression as well.
     */
    private Node findSet(Node n){
        Node parent = n.parent;
        if(parent == n)
            return parent;
        n.parent = findSet(n.parent);
        return n.parent;
    }

}

class CylceUndirectedGraph<T>{
    Problem5DisjointSets ds = new Problem5DisjointSets();
    public boolean hasCycleUsingDisjointSets(Graph<Integer> g){
        for(Vertex<Integer> v:g.getAllVertex()){
            ds.makeSet(v.getId());
        }

        for(Edge<Integer> e: g.getAllEdges()){
            int n1 = ds.findSet(e.getVertex1().getId());
            int n2 = ds.findSet(e.getVertex2().getId());

            if(n1 == n2)
                return true;

            ds.union(n1, n2);
        }
        return false;
    }

    public boolean hasCycleDFS(Graph<T> g){
        Set<Vertex<T>> visited = new HashSet<Vertex<T>>();

        for(Vertex<T> v : g.getAllVertex()){
            if(!visited.contains(v)){
                if(dfsUtil(v, visited, null))
                    return true;
            }
        }
        return false;
    }
    private boolean dfsUtil(Vertex<T> vertex, Set<Vertex<T>> visited, Vertex<T> parent){
        visited.add(vertex);
        for(Vertex<T> v: vertex.getAdjVertexes()){
            if(v.equals(parent)){
                continue;
            }
            if(visited.contains(v))
                    return true;
            if(dfsUtil(v, visited, vertex))
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        Graph<Integer> graph = new Graph<Integer>(false);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 6);
        graph.addEdge(5, 6);
        graph.addEdge(4, 5);
        CylceUndirectedGraph<Integer> ob = new CylceUndirectedGraph<Integer>();
        System.out.println(ob.hasCycleUsingDisjointSets(graph));
        System.out.println(ob.hasCycleDFS(graph));
    }
}