import java.util.Arrays;

//given a string
//reverse only special characters 
//keeping the alphabets intact
//ab@l!*^ -> ab^l*!@
public class ReverseSpecialCharacters {

	public static void main(String[] args) {
		String str = "ab@l!*^";
		reverseSpecialChars(str);
	}

	private static String reverseSpecialChars(String str) {
		if(str==null) {
			return null;
		}
		int length = str.length();
		if(length==1) {
			return str;
		}
		
		int left=0;
		int right = length-1;
		
		char[] toArray = str.toCharArray();
		//parse through each character in the string
		while(left<right) {
			String l = String.valueOf(toArray[left]);
			String r = String.valueOf(toArray[right]);
			if(l.matches("[^A-Za-z0-9]")&&r.matches("[^A-Za-z0-9]")) {
				char temp = toArray[left];
				toArray[left] = toArray[right];
				toArray[right] = temp;
				left++;
				right--;
			} else if(l.matches("[^A-Za-z0-9]")) {
				right--;
			} else if(r.matches("[^A-Za-z0-9]")) {
				left++;
			} else {
				left++;
				right--;
			}
		}
		System.out.println(new String(toArray));
		return new String(toArray);
	}

}
