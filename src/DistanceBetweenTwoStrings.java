//calculate if the distance between two strings
//is equal to the given string
public class DistanceBetweenTwoStrings {

	public static void main(String[] args) {
		boolean isDistance = isDistance("abcaade",'c','d',2);
		System.out.println(isDistance);
	}

	private static boolean isDistance(String str, char c, char d, int k) {
		int length = str.length();
		//validations
		if(str==null) {
			return false;
		}
		
		int nosInBetween = 0;
		boolean prevFound = false;
		//parse the string
		for(int i=0;i<length;i++) {
			if(prevFound&&str.charAt(i)!=d) {
				nosInBetween++;
			} else if(prevFound&&str.charAt(i)==d) {
				prevFound=false;
				break;
			}
			if(str.charAt(i)==c) {
				prevFound = true;
			}
		}
		return (nosInBetween==k)?true:false;
	}

}
