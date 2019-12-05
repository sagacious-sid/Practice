import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TreeBFS {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeOperations op = new TreeOperations();
		root = op.addNode(root, 6);
		root = op.addNode(root, 3);
		root = op.addNode(root, 4);
		root = op.addNode(root, 8);
		root = op.addNode(root, 10);
		root = op.addNode(root, 1);
		root = op.addNode(root, 2);
		System.out.println("InOrder Traversal");
		op.inOrderTraversal(root);
		System.out.println("BST Iterative");
		op.bst(root);
		System.out.println("Tree Height");
		int level = op.getTreeHeight(root);
		System.out.println("height of the tree");
		System.out.println(level+1);
		System.out.println("BST recursive");
		for(int i=0;i<=level;i++) {
			op.bstRec(root, i);
		}
	}

}

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	boolean visited;
	
	public TreeNode(int data) {
		this.data = data;
	}
}

class TreeOperations{
	
	//add a node to a tree
	public TreeNode addNode(TreeNode root, int data) {
		TreeNode newNode = new TreeNode(data);
		if(root==null) {
			return newNode;
		}
		if(root.data<data) {
			root.right = addNode(root.right,data);
		} else {
			root.left = addNode(root.left,data);
		}
		
		return root;
	}
	
	public int getTreeHeight(TreeNode root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null&&root.right==null) {
			return 1;
		}
		int hls = 0;
		int hrs = 0;
		//height of left subtree
		if(root.left!=null) {
			hls = getTreeHeight(root.left);
		}
		if(root.right!=null) {
			hrs = getTreeHeight(root.right);
		}
		
		return (hrs>hls?hrs:hls)+1;
	}

	public void inOrderTraversal(TreeNode root) {
		if(root!=null) {
		inOrderTraversal(root.left);
		System.out.println(root.data);
		inOrderTraversal(root.right);
		}
	}

	//iterative
	public void bst(TreeNode root) {
		//validations
		if(root==null) {
			return;
		}
		
		Queue<TreeNode> bfsQueue = new LinkedList<TreeNode>();
		//we will mark the root node to be visited and add it to the queue
		root.visited = true;
		bfsQueue.add(root);
		
		//we will check each neighbors
		//mark them as visited and add to the queue
		//if there are no neighbors then we dequeue each 
		//and check their neighbors and repeat the same step
		while(!bfsQueue.isEmpty()) {
			TreeNode pop = bfsQueue.poll();
			System.out.println(pop.data+" ");
			if(pop.left!=null) {
				bfsQueue.add(pop.left);
			}
			if(pop.right!=null) {
				bfsQueue.add(pop.right);
			}
		}
	}
	

	
	//recursive
	public void bstRec(TreeNode root, int level) {
		if(root==null) {
			return;
		}
		if(level==0) {
			System.out.println(root.data);
		} else {
			bstRec(root.left,level-1);
			bstRec(root.right, level-1);
		}
	}
}
