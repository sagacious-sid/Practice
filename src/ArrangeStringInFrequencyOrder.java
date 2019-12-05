import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

//given BBBAAAAACCDEEEEEE
//should be arranged in ascending order 
//considering the frequency of each character
//Learnings: java8 sorting a map by values
public class ArrangeStringInFrequencyOrder {

	public static void main(String[] args) {
		arrangeString("BBBAAAAACCDEEEEEE");
	}

	private static void arrangeString(String str) {
		//validations
		if(str==null) {
			return;
		}
		int length = str.length();
		int count = 0;
		Map<Character,Integer> countByEachChar = new HashMap<Character,Integer>();
		for(int i=1;i<length;i++) {
			if(str.charAt(i)==str.charAt(i-1)) {
				count++;
			} else {
				countByEachChar.put(str.charAt(i),count+1);
				count = 0;
			}
		}
		
		//sort the hashmap				
		Map<Character,Integer> sortedMap = new LinkedHashMap<Character, Integer>();
		countByEachChar.entrySet().stream().sorted(Map.Entry.comparingByValue())
			.forEachOrdered(x -> sortedMap.put(x.getKey(),x.getValue()));
		
		
		//print hashmap
		sortedMap.entrySet().stream().forEach(System.out::println);
		
		StringBuilder build = new StringBuilder();
		for(Map.Entry<Character, Integer> entry:sortedMap.entrySet()) {
			int value = entry.getValue();
			while(value>0) {
				build.append(entry.getKey());
				value--;
			}
		}
		System.out.println(build.toString());
	}

}
