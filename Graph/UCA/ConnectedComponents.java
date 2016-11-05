import java.util.*;

class Graph{
    private LinkedList[] adjacencyList;
    public int vertexCount;
    public Graph(int v){
        vertexCount = v;
        adjacencyList = new LinkedList[v];
        for(int i=0; i<v; i++)
            adjacencyList[i] = new LinkedList();
    }

    public void add(int a, int b){
        adjacencyList[a].add(b);
        adjacencyList[b].add(a);
    }
    public int[] adjacentNodes(int vertex){
        int[] adj = new int[adjacencyList[vertex].size()];
        Iterator it = adjacencyList[vertex].listIterator();
        int i = 0;
        while(it.hasNext()){
            adj[i++] = (int)it.next();
        }
        return adj;
    }
}


class ConnectedComponents{
    private int[] cc;
    private boolean[] visited;
    public ConnectedComponents(Graph graph){
        cc = new int[graph.vertexCount];
        visited = new boolean[graph.vertexCount];
        int count = 0;
        for(int i=0; i<graph.vertexCount; i++){
            if(!visited[i]){
                dfs(count, graph, i);
                count++;
            }
        }
    }
    public void dfs(int count, Graph g, int vertex){
        cc[vertex] = count;
        visited[vertex] = true;
        for(int v:g.adjacentNodes(vertex)){
            if(!visited[v])
                dfs(count, g, v);
        }
    }
    public int[] getCC(){
        return cc;
    }
    public static void main(String[] args){
        Graph graph = new Graph(6);
        graph.add(1, 0);
       // graph.add(1, 2);
        graph.add(2, 4);
        graph.add(2, 3);
        graph.add(4, 5);
        graph.add(3, 5);
        ConnectedComponents ob = new ConnectedComponents(graph);
        int[] cc =  ob.getCC();
        for(int i:cc){
            System.out.println(i);
        }

    }
}