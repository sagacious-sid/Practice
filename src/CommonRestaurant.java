import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonRestaurant {

	public static void main(String[] args) {
		String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = {"KFC", "Shogun", "Burger King"};
		Arrays.stream(findRestaurant(list1,list2)).forEach(System.out::println);;
	}
	
    public static String[] findRestaurant(String[] list1, String[] list2) {
        //get the length of both lists
        int length1 = list1.length;
        int length2 = list2.length;
        

        //add any list to the map
        //lets say list1
        Map<String,Integer> minIndexByRest = new HashMap<String,Integer>();
        for(int i=0;i<length1;i++){
            minIndexByRest.put(list1[i],i);
        }
        //we will initialize a maximum value to the min
        int min = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        
        //parse through all the restaurants in second list
        for(int i=0;i<list2.length;i++){
            //check if map of list1 contains the same restaurants
            if(minIndexByRest.containsKey(list2[i])){
                //add their index for finding the minimum value
                //after all the iterations
                int add = i+minIndexByRest.get(list2[i]);
                //get the minimum vallue of sum of both the indexes
                
                if(add==min){
                    result.add(list2[i]); 
                    min = add;
                } else {
                    if(add<min){
                    	min = Math.min(add,min);
                        result.clear();
                        result.add(list2[i]); 
                        min = add;
                    } 
                	
                }
            }
        }
        return result.toArray(new String[result.size()]);
        
    }

}
