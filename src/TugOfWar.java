import java.util.ArrayList;
import java.util.List;

//divide an0 array into two eqoal halves
//difference of the sum of each array should be minimum
public class TugOfWar {

	public static void main(String[] args) {
		int[] arr = {1,2,6,5};
		int minDiff = 0;
		int len = arr.length;
		boolean[] solution = new boolean[len];
		boolean[] visited = new boolean[len];
		divide(arr,len,solution,visited,minDiff,0);
		print(arr,solution);
	}

	private static void print(int[] arr, boolean[] solution) {
		List<Integer> leftList = new ArrayList<Integer>();
		List<Integer> rightList = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(solution[i]) {
				leftList.add(arr[i]);
			} else {
				rightList.add(arr[i]);
			}
		}
		System.out.println(leftList);
		System.out.println(rightList);
	}

	private static boolean[] divide(int[] arr, int len, boolean[] solution, boolean[] visited, int minDiff, int index) {
		if(len==0||len==1) {
			return solution;
		}
		
		int noOfVisited =0;
		for(int i=0;i<len;i++) {
			if(visited[i]) {
				noOfVisited++;
			}
		}
		
		if(noOfVisited==len/2) {
			int diff = getDiff(arr,visited);
			if(diff<minDiff) {
				minDiff = diff;
				solution = updateSolution(solution,visited);
			}
		}
		
		if(index>=len) {
			return null;
		}
		
		//make the recursive call
		visited[index] = true;
		divide(arr, len, solution, visited, minDiff, index+1);
		
		//make the recursive call making the current index as not visited
		visited[index] = false;
		divide(arr, len, solution, visited, minDiff, index+1);
		
		return solution;		
	}

	private static boolean[] updateSolution(boolean[] solution, boolean[] visited) {
		for(int i=0;i<visited.length;i++) {
			solution[i]=visited[i];
		}
		return solution;
	}

	private static int getDiff(int[] arr, boolean[] visited) {
		int leftSum = 0;
		int rightSum = 0;
		for(int i=0;i<arr.length;i++) {
			if(visited[i]) {
				leftSum+=arr[i];
			} else {
				rightSum+=arr[i];
			}
		}
		return leftSum-rightSum;
	}
}
