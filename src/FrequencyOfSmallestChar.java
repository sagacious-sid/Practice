import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrequencyOfSmallestChar {
	public static void main(String[] args) {
		String[] queries = {"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"};
		String[] words = {"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"};
		System.out.println("\n");
		Arrays.stream(numSmallerByFrequency(queries,words)).forEach(System.out::print);;
	}
	
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] queryMap = new int[queries.length];
        int[] wordMap = new int[words.length];
         
         //calculate frequency of each string in queries
         for(int i=0;i<queries.length;i++){
             queryMap[i] = calculateFrequency(queries[i]);
         }
         
         Arrays.stream(queryMap).forEach(System.out::print);
         
         for(int i=0;i<queries.length;i++){
             int freq = calculateFrequency(words[i]);
             wordMap[i] = freq;
         }
         
         System.out.println("\n");
         Arrays.stream(wordMap).forEach(System.out::print);
         System.out.println("\n");
         
         int count = 0;
         List<Integer> res = new ArrayList<Integer>();
         for(int i=0;i<queryMap.length;i++){
             for(int j=0;j<wordMap.length;j++){
                 if(wordMap[j]>queryMap[i]){
                     count++;
                 }
             }
             if(count>0) res.add(count);
             count=0;
         }
         
         return res.stream().mapToInt(i -> i).toArray();
     }
     
     //calculate function of each word
     public static int calculateFrequency(String word){
         //validations
         if(word==null){
             return -1;
         }
         
         //convert it to char array {c,c,d,e}
         char[] letters = word.toCharArray();
         Arrays.sort(letters);
         char frequencyOfLetter = letters[0]; //c
         int count=0;
         //parse through char array to look for the letter
         for(char ch:letters){
             if(ch==frequencyOfLetter){
                 count++;
             }
         }
         return count;
     }

}
