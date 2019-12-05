import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//match two given strings
public class StringMatch {

	public static void main(String[] args) {
		boolean isMatches = isMatch("djujhdj","djujhdj");
		System.out.println(isMatches);
	}

	private static boolean isMatch(String str1, String str2) {
		int length1 = str1.length();
		int length2 = str2.length();
		if(length1!=length2) {
			return false;
		}
		
		int match = 0;
		for(int i=0;i<length1;i++) {
			if(str1.charAt(i)==str2.charAt(i)) {
				match++;
			} else {
				return false;
			}
		}
		
		return (match==length1?true:false);
	}

}
