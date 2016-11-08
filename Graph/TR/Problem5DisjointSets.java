import java.util.*;
/**
 * @author tuhsar kharbanda
 * Date 11/8/2016
 * Disjoint sets using path compression and union by rank
 * Supports 3 operations
 * 1) makeSet
 * 2) union
 * 3) findSet
 *
 * For m operations and total n elements time complexity is O(m*f(n)) where f(n) is
 * very slowly growing function. For most cases f(n) <= 4 so effectively
 * total time will be O(m). Proof in Coreman book.
 */
public class Problem5DisjointSets{
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
    public static void main(String[] args){
        Problem5DisjointSets ds = new Problem5DisjointSets();
        for(int i=1; i<8; i++)
            ds.makeSet(i);
        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);
        for(int i=1; i<8; i++)
            System.out.println(ds.findSet(i));
    }
}