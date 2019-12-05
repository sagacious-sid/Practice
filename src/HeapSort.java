import java.util.Arrays;

//Useful for finding Kth largest element in an array
//useful for sort an almost sorted array
//Useful for merge K sorted arrays
public class HeapSort {

	public static void main(String[] args) {
		int[] arr = {5,7,3,2,8};
		Arrays.stream(heapSort(arr)).forEach(System.out::print);;
	}
	
	public static int[] heapSort(int[] arr) {
		int length = arr.length;
		if(length==0||length==1) {
			return arr;
		}
		
		//heapify first - rearrange items
		for(int i=length/2-1;i>=0;i--) {
			heapify(arr,length,i);
		}
		
		//extract each element from the heap one by one
		//then heapify again
		for(int i=length-1;i>=0;i--) {
			//swap the first and last element
			//moving root to the last element
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr,i,0);
		}
		return arr;
	}

	private static void heapify(int[] arr, int length, int i) {
		int min = i;
		int leftChild = 2*i+1;
		int rightChild = 2*i+2;
		
		//check if leftchild is less than root
		if(leftChild<length&&arr[leftChild]<arr[min]) {
			min = leftChild;
		}
			
		//check if right child is less than root
		if(rightChild<length&&arr[rightChild]<arr[min]) {
			min = rightChild;
		}
		
		//if minimum is not at the root
		//swap the min one to the root
		//rearrange the heap		
		if(min!=i) {
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			
			heapify(arr, length, min);
		}
	}

}
