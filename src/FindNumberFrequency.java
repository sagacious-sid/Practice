import java.math.BigInteger;

//find the frequency of a unique number 
public class FindNumberFrequency {

	public static void main(String[] args) {
		System.out.println(findFrequencyOfUniqueNumber(32659947548398397L,9));
	}

	private static int findFrequencyOfUniqueNumber(long bigNum, int find) {
		int frequency = 0;
		//convert integer to integer array
		//convert to string, then Intstream
		//then convert to the the ascii value of each integer
		//convert them into array
		int[] num = Long.toString(bigNum).chars().map(c->c-'0').toArray();
		for(int n:num) {
			if(find==n) {
				frequency++;
			}
		}
		return frequency;
	}

}
