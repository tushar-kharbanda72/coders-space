public class QueueImplementation{
    class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
    }
    Node head;
    Node tail;

    public boolean isEmpty(){
        return head == null;
    }
    public void add(int data){
        Node node = new Node(data);
        if(tail != null)
            tail.next = node;
        tail = node;
        if(head == null)
            head = tail;
    }
    public int peek(){
        return head.data;
    }

    public int remove(){
        int data = head.data;
        head = head.next;
        if(head == null)
            tail = null;
        return data;
    }
    public static void main(String[] args){

    }
}