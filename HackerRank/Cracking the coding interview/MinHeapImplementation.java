import java.util.*;

class MinHeapImplementation{
    private int capacity = 10;
    private int size = 0;
    private int[] items = new int[capacity];

    private int getLeftChildIndex(int index){
        return 2*index+1;
    }
    private int getRightChildIndex(int index){
        return 2*index+2;
    }
    private int getParentIndex(int index){
        return (index-1)/2;
    }
    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }
    private boolean hasRightChild(int index){
        return getRightChildIndex(index) < size;
    }
    private boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index){
        return items[getLeftChildIndex(index)];
    }
    private int rightChild(int index){
        return items[getRightChildIndex(index)];
    }
    private int parent(int index){
        return items[getParentIndex(index)];
    }

    private void swap(int i1, int i2){
        int t = items[i1];
        items[i1] = items[i2];
        items[i2] = t;
    }
    private void ensureCapacity(){
        if(size == capacity){
            capacity *= 2;
            items = Arrays.copyOf(items, capacity);
        }
    }

    public int peek(){
        if(size == 0)
            throw new IllegalStateException();
        return items[0];
    }
    public int poll(){
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }
    private void heapifyDown(){
        int i = 0;
        while(hasLeftChild(i)){
            int smallerIndex = getLeftChildIndex(i);
            if(hasRightChild(i) && leftChild(i) > rightChild(i))
                smallerIndex = getRightChildIndex(i);

            if(items[i] < items[smallerIndex])
                break;
            else{
                swap(i, smallerIndex);
                i = smallerIndex;
            }
        }
    }
    public void add(int item){
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();

    }
    private void heapifyUp(){
        int i = size-1;
        while(hasParent(i) && parent(i) > items[i]){
            swap(i, getParentIndex(i));
            i = getParentIndex(i);
        }
    }

    public static void main(String[] args){
        MinHeapImplementation priorityQueue = new MinHeapImplementation();
        priorityQueue.add(10);
        priorityQueue.add(5);
        priorityQueue.add(15);
        priorityQueue.add(1);
        priorityQueue.add(4);
        System.out.println(priorityQueue.peek());
    }
}