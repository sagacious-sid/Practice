
public class ImplementSinglyLikedList {

	public static void main(String[] args) {
		SinglyNode head = new SinglyNode(8);
		head.insertNodeAtLast(9);
		head.printList();
	}

}

class SinglyNode{
	int val;
	SinglyNode next;
	
	public SinglyNode(int val) {
		this.val = val;
	}
	
	public void printList() {
		SinglyNode curr = this;
		while(curr!=null) {
			System.out.println(curr.val);
			curr = curr.next;
		}
	}

	public void insertNodeAtLast(int data) {
		SinglyNode newNode = new SinglyNode(data);
		this.next = newNode;
		newNode.next = null;
	}
}
