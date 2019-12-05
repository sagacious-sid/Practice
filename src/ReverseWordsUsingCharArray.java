import java.util.Arrays;
import java.util.stream.Stream;

public class ReverseWordsUsingCharArray {

	public static void main(String[] args) {
		char[] s = {'t','h','e',' ','s','k','y',' ','i','s'};
		reverseWords(s);
	}

	public static void reverseWords(char[] s) {
        //validations
        int length = s.length;
        if(length==0||length==1){
            return;
        }
        
        //reverse the whole array
        reverse(s,0,length-1);
        
        //reverse each block of strings one by one
        int left =0;
        int right=0;
        
        //loop across each element and find the space
        //if space is at the ith position 
        //the right will be i-1
        //and left will be the first position
        for(int i=0;i<length;i++){
            if(s[i]==' '||i==length-1){
                right = (i==length-1)?i:i-1;
                reverse(s,left,right);
                left=i+1;
            } else {
                continue;
            }
        }
        for(int i=0;i<s.length;i++) {
        	System.out.print(s[i]);
        }
    }
    
    //method to reverse a character array 
    //with start and end position given
    public static void reverse(char[] s,int left,int right){
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
