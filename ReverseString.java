
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(reverseRecurssive("How you doing"));
		System.out.println(reverseIterative("How you doing"));
		

	}

	/* Reverse a string iterative call
	 * 
	 */
	private static String reverseIterative(String input) {
		
		if(input == null || input.length()<1) return "";
		
		char [] charArr = input.toCharArray();
		int start = 0;
		int end = charArr.length-1;
		
		while(start<end){
			char temp = charArr[end];
			charArr[end--] = charArr[start];
			charArr[start++] = temp;
		}
		return new String(charArr);
	}

	/* reversing the string recurssive
	 * 
	 */
	private static String reverseRecurssive(String input) {
		String result = "";
		// terminating condition
		if(input==null || input.length() < 1) 
			return "";

		// The recussive call is made first and then the CurrentLevel Character is added
		// if you reverse teh call it wont reverse
		result += reverseRecurssive(input.substring(1, input.length()))  + input.substring(0, 1) ;
		
		return result;
	}

}
