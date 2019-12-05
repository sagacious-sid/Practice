import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigzagListBinaryTree {
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	    
	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        if(root==null){
	            return Collections.emptyList();
	        }
	        List<List<Integer>> zigzagList = new ArrayList<List<Integer>>();
	        //calculate the depth of the tree
	        int depth = getDepth(root);
	        
	        //parse through each level of depth
	        List<Integer> eachLevelList = new ArrayList<Integer>();
	        for(int i=0;i<depth;i++){
	            zigzagList.add(bfs(root,depth-1,eachLevelList));
	        }
	        return zigzagList;
	    }
	    
	    public List<Integer> bfs(TreeNode root,int level,List<Integer> eachLevelList){
	        if(level==0){
	            System.out.println(root.data);
	            eachLevelList.add(root.data);
	        }
	        
	        //recursively print every level
	        if(level%2==0){
	            bfs(root.left,level-1,eachLevelList);
	            bfs(root.right,level-1,eachLevelList);
	        } else{
	            bfs(root.right,level-1,eachLevelList);
	            bfs(root.left,level-1,eachLevelList);
	        }
	        return eachLevelList;
	    }
	    
	    public int getDepth(TreeNode root){
	        //validations or restricting conditions
	        if(root==null){
	            return 0;
	        }
	        //calculate the maximum depth of left and right subtree
	        int dl = 0;
	        int dr = 0;
	        dl = getDepth(root.left);
	        dr = getDepth(root.right);
	        return ((dl>dr)?dl:dr)+1;
	    }
	}
