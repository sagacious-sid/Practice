import java.util.Dictionary;

public class CompareVersions {

	public static void main(String[] args) {
		System.out.println(compareVersions("1.1.1.1","1.1.2.1"));
		System.out.println(compareVersions("1.1.1.1","1.1"));
		System.out.println(compareVersions("2.0.1.","1.1"));
		System.out.println(compareVersions("1.1","1.1"));
		System.out.println(compareVersionsOptimized("1.01","1.1"));
	}

	private static String compareVersions(String v1, String v2) {
		int lengthV1 = v1.length();
		int lengthV2 = v2.length();
		int smaller = (lengthV1>lengthV2)?lengthV2:lengthV1;
		int count =0;
		for(int i=0;i<smaller;i++) {
			if(v1.charAt(i)==v2.charAt(i)) {
				count++;
				continue;
			} else if(v1.charAt(i)>v2.charAt(i)){
				return v2;
			} else {
				return v1;
			}
		}
		if(count==smaller&&lengthV1!=lengthV2) {
			return (lengthV1==smaller)?v1:v2;
		} else if(count==smaller&&lengthV1==lengthV2) {
			return "same";
		}
		return null;
	}
	
	//when 01 or 02 is present in the string
	private static String compareVersionsOptimized(String v1, String v2) {
		//convert string to array of numbers 
		//we can parse each one and compare
		String[] strArrayWithoutDots1 = v1.split(".");
		String[] strArrayWithoutDots2 = v2.split(".");
		
		//calculate the smaller length
		int lengthV1 = strArrayWithoutDots1.length;
		int lengthV2 = strArrayWithoutDots2.length;
		int smaller = (lengthV1>lengthV2)?lengthV2:lengthV1;
		int count = 0;
		
		for(int i=0;i<smaller;i++) {
			if(Integer.parseInt(strArrayWithoutDots1[i])==Integer.parseInt(strArrayWithoutDots2[i])) {
				count++;
				continue;
			} else if(Integer.parseInt(strArrayWithoutDots1[i])>Integer.parseInt(strArrayWithoutDots2[i])){
				return v2;
			} else {
				return v1;
			}
		}
		
		if(count==smaller&&lengthV1!=lengthV2) {
			return (lengthV1==smaller)?v1:v2;
		} else if(count==smaller&&lengthV1==lengthV2) {
			return "same";
		} else {
			return null;
		}
	}

}
