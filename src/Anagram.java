import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//get the anagrams list of the given array of string
//learnings: anagrams can be easily found using sorting
//java 8 stream features to get the values from a map
//java8 map method getOrDefault(key, default value)

public class Anagram {

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        //sort all the strings in the array
        //compare each element
        //if string matches
        //put it into the list
        //else
        //create a new list and continue
        
        //follows insertion order
        List<String> sortedList = new ArrayList<String>();
        Map<String,List<String>> sortMap = new HashMap<String,List<String>>();
        
        //sort each string
        for(int i=0;i<strs.length;i++){
            //convert it into char array
            char[] strArr = strs[i].toCharArray();
            Arrays.sort(strArr);
            String sortedString = new String(strArr);
            List<String> anaList = sortMap.getOrDefault(sortedString,new ArrayList<String>());
            anaList.add(strs[i]);
            //put the value into map
            sortMap.put(sortedString,anaList);
        }
        
        //older way to get the list using a map
        List<List<String>> anagramList = new ArrayList<List<String>>();
        //parse through the map and add each element to result list
        for(Map.Entry<String,List<String>> entry:sortMap.entrySet()){
            List<String> val = entry.getValue();
            anagramList.add(val);
        }
        
        //using streams to get the list from the map
        List<List<String>> anagramListStream = sortMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        
        return anagramListStream;
        
    }

}
