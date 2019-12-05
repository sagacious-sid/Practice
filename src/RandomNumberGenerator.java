import java.time.Instant;
import java.util.Random;

//generate random number based on current timestamp
public class RandomNumberGenerator {

	public static void main(String[] args) {
		System.out.println(generateRandomNumber());
	}

	private static long generateRandomNumber() {
		//get the system current timestamp in millis
		long timestamp = Instant.now().toEpochMilli();
		System.out.println(timestamp);
		long randomNumber = new Random().nextInt(100);
		System.out.println(randomNumber);
		
		//append both of them
		long randNum = Long.parseLong(timestamp+""+randomNumber);
		return randNum;
	}

}
