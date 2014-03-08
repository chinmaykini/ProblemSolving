import java.util.Stack;

public class NumberBaseRespresenation {

	/**
	 * Write a recursive function which takes an integer, n, and a base, b, as
	 * arguments and returns a list of the digits of n in base b.
	 * 
	 * Examples: 
	 * n: 64, b:2 => (1,0,0,0,0,0,0) 
	 * n: 64, b:10 => (6,4) 
	 * n: 128, b:10 * => (1,2,8) 
	 * n: 128, b:2 => (1,0,0,0,0,0,0,0)
	 */
	
	/*
	 * The function that breaks the digits of
	 * the number to the given base
	 */
	public static Stack<Integer> modifyier(Integer n, Integer base)
			throws Exception {

		Stack<Integer> result = new Stack<Integer>();
		if (base == 0)
			throw new Exception();

		// until number 0
		while (n > 0) {

			int currentResult = n % base;
			n = n / base;
			result.push(currentResult);
		}

		return result;
	}
	
	/*
	 * helper function to convert Stack to String
	 */
	public static String stacktoString(Stack<Integer> stack) {
		
		StringBuilder result = new StringBuilder();

		while (!stack.isEmpty()) {
			result.append(stack.pop().toString()).append(",");
		}
		return result.toString();
	}

	public static void main(String[] args) {

		try {
			
			Integer number = 64;
			Integer base = 10;
			
			System.out.println(stacktoString(modifyier(number, base)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
