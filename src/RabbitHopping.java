
//A rabbit can hop one step and two step at a time
//possible combinations to get to Nth step
//this issue is mostly like fibonacci sequence
public class RabbitHopping {

	public static void main(String[] args) {
		System.out.println(noOfHops(4));
		System.out.println(noOfHops(7));
	}
	
	public static int noOfHops(int N) {
		if(N==1||N==0) {
			return 1;
		}
		if(N==2) {
			return 2;
		}
		
		return noOfHops(N-1)+noOfHops(N-2);
		
	}

}
