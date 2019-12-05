import java.util.HashMap;
import java.util.Map;

public class CacheOperation {

	private static final int CACHE_CAPACITY = 2;
	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(CACHE_CAPACITY);
		lruCache.put(1, 1);
		lruCache.put(2, 3);
		lruCache.put(3, 4);
		lruCache.put(3, 4);
	}

}

class LRUCache{
	
	private int cacheCap;
	Node head;
	Node tail;
	int totalItems;
	private Map<Integer,Node> cacheMap = new HashMap<Integer,Node>();
	public LRUCache(int cacheCap) {
		this.cacheCap = cacheCap;
		this.head = new Node(-1, -1);
		this.tail = new Node(-1,-1);
		//wire head and tail together
		head.next = tail;
		tail.prev = head;
		this.totalItems = 0;
	}
	
	public void put(int key,int value) {
		//check if the key item already exists or not
		if(!cacheMap.containsKey(key)) {
			//create new node since its not in the cache already
			Node newNode = new Node(key,value);
			//add the new element or node to the front
			addToFront(newNode);
			totalItems++;
			
			//if the total items is more than capacity
			//we have to evict
			if(totalItems>cacheCap) {
				removeNode();
				totalItems--;
			}
			
			//add to the cacheMap
			cacheMap.put(key, newNode);
		} else {
			Node node = cacheMap.get(key);
			node.value = value;
			moveToFront(node);
		}
		
	}
	
	public Map<Integer,Node> getCacheMap() {
		return cacheMap;
	}

	private void moveToFront(Node node) {
		removeNode();
		addToFront(node);
	}

	private void removeNode() {
		Node nodeToRemove = getNodeToRemove();
		
		//save the last but one node and the next one
	    Node savedPrev = nodeToRemove.prev;
	    Node savedNext = nodeToRemove.next;

	    savedPrev.next = savedNext;
	    savedNext.prev = savedPrev;
		
		//remove it from the map
		cacheMap.remove(nodeToRemove.key);
	}

	private Node getNodeToRemove() {
		Node removeNode = tail.prev;
		return removeNode;
	}

	private void addToFront(Node newNode) {
		//obvious validations
		if(newNode==null) {
			return;
		}
		newNode.prev = head;
		newNode.next = head.next;
		
		//head and head.next should be pointing to new node
		head.next.prev = newNode;
		head.next = newNode;
		
	}
}

class Node{
	int key;
	int value;
	Node prev;
	Node next;
	
	public Node(int key,int value) {
		this.key = key;
		this.value = value;
	}
}
