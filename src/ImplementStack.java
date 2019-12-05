import java.util.Arrays;

//implement stack using arrays
public class ImplementStack {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(2);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		stack.print();
	}

}

class Stack{
	int top;
	int arr[];
	public static int MAX_SIZE = 4;
	
	public Stack() {
		top = -1;
		arr = new int[MAX_SIZE];
	}
	
	public void push(int val) {
		if(top<MAX_SIZE-1) {
			arr[++top] = val;
		} else {
			MAX_SIZE++;
			int[] increasedSizedArray = new int[MAX_SIZE];
			for(int i=0;i<arr.length;i++) {
				increasedSizedArray[i] = arr[i];
			}
			arr = increasedSizedArray;
			arr[++top] = val;
		}
		
	}
	
	public int pop() {
		if(!isEmpty()) {
			int pop = arr[top];
			top--;
			return pop;
		} else {
			return Integer.MIN_VALUE;
		}
	}
	
	public int peek() {
		return arr[top];
	}
	
	public boolean isEmpty() {
		return (top==-1)?true:false;
	}
	
	public void print() {
		Arrays.stream(arr).limit(top+1).forEach(System.out::print);
	}
}
