import java.util.Arrays;

//It is kind of same as Priority Queues
public class HeapBinary {

	public static void main(String[] args) {
		Heap heap = new Heap(4);
		heap.insert(2);
		heap.insert(4);
		heap.insert(6);
		heap.getMin();
		heap.extractMin();
		heap.remove();
		heap.insert(3);
		heap.remove();
	}

}

class Heap{
	int[] heap;
	int heapSize;
	
	public Heap(int MAX_SIZE) {
		heapSize = 0;
		heap = new int[MAX_SIZE];
		Arrays.fill(heap,-1);
	}
	
	public void insert(int x) {
		if(heapSize>heap.length-1)
			throw new IllegalStateException();
		
		heap[heapSize] = x;
		heapSize++;
		
		//since we added an extra element at the last
		//we will bubble it up
		heapifyUp(heapSize-1);
	}
	
	public void remove() {
		if(heapSize==0)
			throw new IllegalStateException();
		
		heap[0] = heap[heapSize-1];
		heapSize--;
		heapifyDown();
	}
	
	public int getMin() {
		return heap[0];
	}
	
	public int extractMin() {
		int min = heap[0];
		heapSize--;
		heapifyDown();
		return min;
	}
	
	public int getParentIndex(int i) {
		return (i-1)/2;
	}
	
	public int getLeftChildIndex(int i) {
		return (2*i)+1;
	}
	
	public int getRightChildIndex(int i) {
		return (2*i)+2;
	}
	
	public void heapifyUp(int childIndex) {
		//get the inserted item to bubble up
		int temp = heap[childIndex];
		//continue till you get it to the right position
		//which is it should be greater than its parent node
		while(childIndex>0&&heap[getParentIndex(childIndex)]>temp) {
			//swap it with the parent
			heap[childIndex] = heap[getParentIndex(childIndex)];
			//child index should be the current index of parent after swap
			childIndex = getParentIndex(childIndex);
		}
		//after the child is swapped with all its parent
		//the resultant parent index should be the temp
		//since we found out the position where the new
		//inserted element has to fit
		heap[childIndex] = temp;
	}
	
	public void heapifyDown() {
		//get the top or first item to bubble down
		int index = 0;
		int temp = heap[0];
		//loop till it reaches its correct position
		//compare it with left and right child
		//swap it with the child which is least among 
		//its children
		while(index<heap.length) {
			int leftChild = getLeftChildIndex(index);
			int rightChild = getRightChildIndex(index);
			int smallerIndex = (heap[leftChild]<heap[rightChild])?leftChild:rightChild;
			if(temp>heap[smallerIndex]) {
				heap[smallerIndex] = heap[index];
			} else {
				break;
			}
			index = smallerIndex;	
		}
		heap[index] = temp;
	}
	
	public boolean isFull() {
		return heapSize==heap.length?true:false;
	}
	
	public boolean isEmpty() {
		return heapSize==0?true:false;
	}
	
}
