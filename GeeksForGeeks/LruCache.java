import java.util.HashMap;
class LruCache {

    class Node {
        int val;
        Node next, before;
        public Node(int d) {
            this.val = d;
            next = before = null;
        }
    }

    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head;
    private Node tail;
    private int MAX_SIZE;
    private int size = 0;
    public LruCache(int s){
        MAX_SIZE = s;
    }

    public void used(int v) {
        if(containsInCache(v)) {
            Node node = map.get(v);
            if(node != head){
            deleteFromCache(v);
            node.next = head;
            head.before = node;
            head = node;
            map.put(v, node);
        }

        } else {
            addIntoCache(v);
        }
    }

    public void addIntoCache(int v) {
        size++;
        if(head == null) {
            Node node = new Node(v);
            head = node;
            tail = node;
            map.put(v, node);
            return;
        }

        if(size > MAX_SIZE) {
            tail = tail.before;
            Node next = tail.next;
            next.before = null;
            tail.next = null;
            map.remove(next.val);
        }

        Node node = new Node(v);
        node.next = head;
        if(head != null) {
            head.before = node;
        }
        head = node;
        map.put(v, node);
    }

    public void deleteFromCache(int v) {
        Node node = map.get(v);
        if(node == null)
            return;
        map.remove(v);
        if(size == 1) {
            head = null;
            tail = null;
        }
        else if(head == node) {
            head = node.next;
            if(head != null) {
                head.before = null;
            }
            node.next = null;
        } else if(node == tail) {
            tail = tail.before;
            tail.next = null;
        } else {
            Node before = node.before;
            Node next = node.next;
            before.next = next;
            next.before = before;
        }
    }

    public void printCache() {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private boolean containsInCache(int v) {
        return map.containsKey(v);
    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(5);

        lruCache.used(4);

        lruCache.used(5);
        lruCache.printCache();
        lruCache.used(6);
        lruCache.printCache();
        lruCache.used(5);
        lruCache.printCache();
        lruCache.used(9);
        lruCache.printCache();
        lruCache.used(10);
        lruCache.printCache();
        lruCache.used(11);
        lruCache.printCache();
        lruCache.used(16);
        lruCache.printCache();
        lruCache.used(10);
        lruCache.printCache();
        lruCache.deleteFromCache(10);
        lruCache.printCache();
        lruCache.deleteFromCache(9);
        lruCache.printCache();
    }
}