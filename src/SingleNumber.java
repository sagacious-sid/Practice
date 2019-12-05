import java.util.Arrays;

public class SingleNumber {

	public static void main(String[] args) {
		int[] nums = {2,2,1};
		singleNumber(nums);
	}
    public static int singleNumber(int[] nums) {
        //sort the array
        //check ith and ith-1 are equal 
        
        Arrays.sort(nums);
        int length = nums.length;
        for(int i=1;i<length;i+=2){
            if(i==length-2){
                return nums[i+1];
            }
            if(nums[i]==nums[i-1]){
                continue;
            } else{
                return nums[i-1];
            }
        }
        return -1;
    }

}
