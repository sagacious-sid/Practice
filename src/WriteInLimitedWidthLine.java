//given a string and length of each line
//no word should be dessicated 
//print the given string
public class WriteInLimitedWidthLine {

	public static void main(String[] args) {
		printInLine("Hey there! How are you doing today?",7);
	}

	private static void printInLine(String str, int width) {
		int length = str.length();
		if(length<width) {
			System.out.println(str);
		}
		
		//convert it into char array for each word to fit in the line
		String[] words = str.split(" ");
		int i=0;
		int widthThreshold = 0;
		while(i<words.length) {
			widthThreshold+=words[i].length()+1;
			if(widthThreshold<=width) {
				System.out.print(words[i]+" ");
			} else {
				System.out.print("\n"+words[i]+" ");
				widthThreshold = 0;
			}
			i++;
		}
	}

}
