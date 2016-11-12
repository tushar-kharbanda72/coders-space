
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

class EdgeComparator implements Comparator<Edge<Integer>>{
    @Override
    public int compare(Edge<Integer> e1, Edge<Integer> e2){
        if(e1.getWeight() > e2.getWeight())
            return 1;
        else    return -1;
    }
}

class Problem4KruskalAlgorithm{
    public List<Edge<Integer>> mst(Graph g){
        List<Edge<Integer>> allEdges = g.getAllEdges();
        Collections.sort(allEdges, new EdgeComparator());
        Problem5DisjointSets ds = new Problem5DisjointSets();
        Collection<Vertex<Integer>> allVertex = g.getAllVertex();
        for(Vertex<Integer> v : allVertex){
            ds.makeSet(v.getId());
        }

        List<Edge<Integer>> res = new ArrayList<Edge<Integer>>();
        for(Edge<Integer> e : allEdges){
            int p1 = ds.findSet(e.getVertex1().getId());
            int p2 = ds.findSet(e.getVertex2().getId());

            if(p1 == p2)
                continue;
            res.add(e);
            ds.union(e.getVertex1().getId(), e.getVertex2().getId());
        }
        return res;
    }
    public static void main(String[] args){
        Graph<Integer> graph = new Graph<Integer>(false);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 6, 3);
        graph.addEdge(2, 4, 2);
        graph.addEdge(6, 5, 2);
        graph.addEdge(6, 4, 3);
        graph.addEdge(4, 7, 2);
        graph.addEdge(3, 4, 5);
        graph.addEdge(3, 7, 8);

        Problem4KruskalAlgorithm ob = new Problem4KruskalAlgorithm();
        List<Edge<Integer>> res = ob.mst(graph);

        for(Edge<Integer> e : res){
            System.out.println("Edge-" + e.getVertex1().getId() + ", " + e.getVertex2().getId());
        }
    }
}