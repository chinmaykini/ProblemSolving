import java.util.Stack;


public class RPN {

	public static void main(String[] args) {

		String input = "21+3*";
		Integer result = rpn(input);
		System.out.println(result);
	}

	private static Integer rpn(String input) {
		
		Stack<Integer> stack = new Stack<Integer>();
		char[] tokens = input.toCharArray();
		String operands = "+-*/";
		for(Character token : tokens){
			if(!operands.contains(token.toString())) {
				stack.push(Integer.parseInt(token.toString()));
			}else{
				Integer first = stack.pop();
				Integer second = stack.pop();
				switch (token) {
				case '+':
					stack.push(first+second);
					break;
				case '-':
					stack.push(second-first);
					break;
				case '*':
					stack.push(second*first);
					break;
				case '/':
					stack.push(second/first);
					break;
				}
			}				
		}
		return stack.pop();
	}

}
