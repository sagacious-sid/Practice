import java.util.Stack;
//learnings:
//char to string -> Character.toString(char)
public class ReverseExpression {

	public static void main(String[] args) {
		String s = "1+2*3-20";
		System.out.println(reverseExpression(s));
	}

	private static String reverseExpression(String s) {
		if(s==null) {
			return "";
		}
		
		int length = s.length();
		if(length==1) {
			return s;
		}
		
		//use a stack structure to access the string in reverse form
		int index = 0;
		Stack<String> stack = new Stack<String>();
		for(int i=1;i<length;i++) {
			if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/') {
				stack.push(s.substring(index, i));
				index = i+1;
				stack.push(Character.toString(s.charAt(i)));
			}
			
			if(i==length-1) {
				stack.push(s.substring(index,length));
			}
		}
		
		//pop from the stack LIFO
		StringBuilder str = new StringBuilder();
		while(!stack.isEmpty()) {
			str.append(stack.pop());
			
		}
		return str.toString();
		
	}

}
