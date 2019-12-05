import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//return the indices of two numbers whose sum
//is equal to the given number
public class TwoSumProblem {

	public static void main(String[] args) {
		int[] arr = {2,7,11,15};
		System.out.println(twoSum(arr,9));
	}
	
	//iterative method
	public static List<Integer> twoSum(int[] arr,int sum) {
		List<Integer> indexList = new ArrayList<Integer>();
		Arrays.sort(arr);
		int length = arr.length;
		int i=0;
		int j=length-1;
		
		while(i<j) {
			int add = arr[i]+arr[j];
			if(add>sum) {
				j--;
			}else if(add<sum) {
				i++;
			} else {
				indexList.add(arr[i]);
				indexList.add(arr[j]);
				i++;
				j--;
			}
		}
		return indexList;
	}
}
