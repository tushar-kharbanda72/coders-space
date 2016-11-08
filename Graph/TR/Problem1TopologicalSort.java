import java.util.*;

class Graph{
    LinkedList[] adjList;
    int vertexCount;
    public Graph(int vc){
        this.vertexCount = vc;
        adjList = new LinkedList[vertexCount];
        for(int i=0; i<vertexCount; i++)
            adjList[i] = new LinkedList();
    }

    public void addEdge(int source, int destination){
        adjList[source].add(destination);
    }

    public int[] adj(int vertex){
        Iterator it = adjList[vertex].listIterator();
        int[] adjV = new int[adjList[vertex].size()];
        int index = 0;
        while(it.hasNext()){
            adjV[index++] = (int)it.next();
        }
        return adjV;
    }
}

class Problem1TopologicalSort{

    public void topologicalSort(Graph g){
            Set<Integer> visited = new HashSet<Integer>();
            Stack<Integer> res = new Stack<Integer>();
            for(int i=0; i<g.vertexCount; i++){
                if(!visited.contains(i)){
                    topSortUtil(i, visited, res, g);
                }
            }
            while(res.size() > 0){
                System.out.println(res.pop());
            }
        }

        public void topSortUtil(int i, Set<Integer> visited, Stack<Integer> res, Graph g){
            visited.add(i);
            for(Integer n: g.adj(i)){
                if(!visited.contains(n)){
                    topSortUtil(n, visited, res, g);
                }
            }
            res.push(i);
        }
    public static void main(String[] args){
        Graph g = new Graph(7);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        Problem1TopologicalSort ob = new Problem1TopologicalSort();
        ob.topologicalSort(g);
    }
}