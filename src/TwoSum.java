import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		for(int i=0;i<twoSum(nums,target).length;i++) {
			System.out.println(twoSum(nums,target)[i]);
		}
		IntStream.of(twoSum(nums,target)).forEach(System.out::print);
		Arrays.stream(twoSum(nums,target)).forEach(System.out::print);
		Arrays.stream(twoSum(nums,target)).mapToObj(Integer::toString).collect(Collectors.toList()).forEach(System.out::println);
		Arrays.stream(twoSum(nums,target)).mapToObj(Integer::toString).collect(Collectors.joining(", "));
	}

	private static int[] twoSum(int[] nums, int target) {
		//craeate a hashmap and add thhe number and its index
		Map<Integer,Integer> numByIndex = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			//check the number to get the target
			int diff = target-nums[i];
			//if map already contains the element
			//whose sum will give target then return the indexes
			if(numByIndex.containsKey(diff)&&i!=numByIndex.get(diff)) {
				return new int[] {numByIndex.get(diff),i};
			} else {
				//just go ahead and populate the map
				numByIndex.put(nums[i],i);
			}
		}
		return new int[0];
	}

}
