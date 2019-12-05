
public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] nums = {1,1,2};
		removeDuplicates(nums);
	}
	
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length==0){
            return -1;
        }
        if(length==1){
            return nums[0];
        }
        int tracker = 0;
        //parse through all the numbers in the array
        for(int i=1;i<length;i++){
            if(nums[i]!=nums[tracker]){
                tracker++;
                nums[tracker] = nums[i];
            }
        }
        return tracker;
    }

}
