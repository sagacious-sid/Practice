import java.util.HashMap;
import java.util.Map;

//implement LRUCache
//implement get and put methods
public class LRUCacheExplained {
	
	//most important is its data structure
	//we will use HashMap backed up by a list
	Map<Integer,LRUCacheNode> lruCache = new HashMap<Integer,LRUCacheNode>();
	//we define head and tail for the doubly linked list which is 
	//like a value in this case
	LRUCacheNode head;
	LRUCacheNode tail;
	
	//define the size of the cache filled and size limit
	private static int MAX_SIZE = 5;
	int sizeFilled = 0;
	
	//initialize the default constructor
	public LRUCacheExplained() {
		head = new LRUCacheNode(-1,-1);
		tail = new LRUCacheNode(-1,-1);
		
		head.next = tail;
		tail.prev = head;
	}
	
	//first api is to insert a key-value pair to the cache
	public void put(int key,int value) {
		//we need to first check if the node already exists in 
		//the cache map
		LRUCacheNode newNode = lruCache.get(key);
		
		if(newNode==null) {
			//since the element which is inserted is the most recent
			//so it should be inserted at the first
			//first we will create the node using key and value
			LRUCacheNode node = new LRUCacheNode(key, value);
			
			//since adding at the front can be used multiple times
			//we can segregate into methods
			addToFront(node);
			
			//insert the new node into the map
			lruCache.put(key,node);
			sizeFilled++;
			
			//check if the size filled is greater than max capacity
			if(sizeFilled>MAX_SIZE) {
				//remove the least recent used value from the list
				//we will make another method to remove from the list
				removeLRU();
			}
		} else {
			//update the value of the new node and move it to the head
			newNode.value = value;
			moveToHead(newNode);
		}
	}

	private void addToFront(LRUCacheNode node) {
		//the node prev and next pointer should be point to head and to
		//the element head is pointing to respectively
		node.prev = head;
		node.next = head.next;
		
		//since the node is hanging in between
		//we will wire it tightly
		head.next = node;
		head.next.prev = node;
	}

	private void moveToHead(LRUCacheNode newNode) {
		removeFromList(newNode);
		addToFront(newNode);
	}

	private void removeLRU() {
		//get the last node to delete
		LRUCacheNode nodeToBeDeleted = getLastNode();
		
		//point the tail's prev to the node prev to the node 
		//which is to be deleted
		//since removal from the list is exclusive as we might have
		//to do this operaion multiple times, we will separate the method
		removeFromList(nodeToBeDeleted);
		
		//once it is removed from the doubly linked list
		//we can remove it from the map
		removeFromMap(nodeToBeDeleted);
		sizeFilled--;
	}

	private void removeFromList(LRUCacheNode nodeToBeDeleted) {
		//node's previous nexrt should be the
		//next node to the node which we gonna delete
		nodeToBeDeleted.prev.next = nodeToBeDeleted.next;
		nodeToBeDeleted.next.prev = nodeToBeDeleted.prev; 
	}

	private void removeFromMap(LRUCacheNode nodeToBeDeleted) {
		lruCache.remove(nodeToBeDeleted.key);
	}

	private LRUCacheNode getLastNode() {
		return tail.prev;
	}

	public static void main(String[] args) {
		LRUCacheExplained lruCache = new LRUCacheExplained();
		lruCache.put(1, 1);
		lruCache.put(2, 3);
		lruCache.put(3, 4);
		lruCache.put(3, 4);
	}
	
	//second api will be get
	public int get(int key) {
		LRUCacheNode node = lruCache.get(key);
		
		//return -1 if there is no node present
		if(node==null) {
			return -1;
		}
		
		//then move the current accessed node to the front
		moveToHead(node);
		return node.value;
	}

}


class LRUCacheNode{
	int key;
	int value;
	
	LRUCacheNode prev;
	LRUCacheNode next;
	
	public LRUCacheNode(int key,int value) {
		this.key = key;
		this.value = value;
	}
}