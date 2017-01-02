// Problem 7.2 - Implement Hash table using linked list to handle collision.

import java.util.ArrayList;
public class HashTable<k, v>{
	// doubly linked list. should only be accessed in HashTable i.e why private. 
	private static class LinkedListNode<k, v>{
		public LinkedListNode<k, v> next;
		public LinkedListNode<k, v> prev;
		public k key;
		public v value;
		public LinkedListNode(k key, v value){
			this.key = key;
			this.value = value;
		} 
	}

	public ArrayList<LinkedListNode<k, v>> arr;
	public HashTable(int capacity){
		// create list of linked lists of given capacity.
		arr = new ArrayList<LinkedListNode<k, v>>();
		for(int i = 0; i < capacity; i++){
			arr.add(null);
		}
	}

	// insert key and value into hash table.
	public void put(k key, v value){
		LinkedListNode<k, v> node = getNodeForKey(key);
		if(node != null){//already there.
			node.value = value;//just update the value.
			return;
		}
		node = new LinkedListNode<k, v>(key, value);
		int index = getIndexForKey(key);

		if(arr.get(index) != null){
			node.next = arr.get(index);
			node.next.prev = node;
		}
		arr.set(index, node);
	}

	//Remove node for key.
	public void remove(k key){
		LinkedListNode<k, v> node = getNodeForKey(key);
		if(node.prev != null){
			node.prev.next = node.next;
		}else{ //Removing head-update.
			int index = getIndexForKey(key);
			arr.set(index, node.next);
		}
		if(node.next != null){
			node.next.prev = node.prev;
		}	
	}
	// Get value for a key.
	public v get(k key){
		LinkedListNode<k, v> node = getNodeForKey(key);
		return node == null ? null : node.value;
	}
	// Get linked list node associated with a given key.
	private LinkedListNode<k, v> getNodeForKey(k key){
		int index = getIndexForKey(key);
		LinkedListNode<k, v> curr = arr.get(index);

		while(curr != null){
			if(curr.key == key){
				return curr;
			}
			curr = curr.next;
		}
		return null;
	}

	// to map a key to index.
	private int getIndexForKey(k key){
		return Math.abs(key.hashCode()%arr.size());
	}

	public static void main(String[] args){

	}
}
