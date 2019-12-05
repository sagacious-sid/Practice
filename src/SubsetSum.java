import java.util.Arrays;

//find all the subsets whose sum is K
public class SubsetSum {

	public static void main(String[] args) {
		int[] arr = { 5, 2, 6, 8, 1, 3, 1, 8 };
		Arrays.sort(arr);
		System.out.println(subSetSum(arr, arr.length - 1, 7));
		// looks like we need backtracking
		// Why?? the elements in each subset can be of different length
		// at runtime we can decide the length of each subset so that the sum is K

	}

	
	private static boolean subSetSum(int[] arr, int length, int K) {

		if (length < 0 || K < 0) {
			return false;
		}
		if (K == 0) {
			return true;
		}

		// calling the same subset recursively
		boolean include = subSetSum(arr, length - 1, K - arr[length]);

		boolean exclude = subSetSum(arr, length - 1, K);

		return include || exclude;
	}
}
