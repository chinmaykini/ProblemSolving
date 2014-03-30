import java.util.HashMap;


public class RomanNumerals {

	public static HashMap<Character, Integer> romanMap;
	
	public static void main(String[] args) {
		
		romanMap = new HashMap<Character, Integer> (); 
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		
		System.out.println(romanToInteger("XII"));
		System.out.println(romanToInteger("I"));
		System.out.println(romanToInteger("VI"));
		System.out.println(romanToInteger("IV"));
		System.out.println(romanToInteger("VII"));
		String romanResult = integerToRoman(12);

	}

	private static String integerToRoman(Integer number) {
		// http://fisherlei.blogspot.com/2012/12/leetcode-integer-to-roman.html
		//http://tianrunhe.wordpress.com/2012/07/24/convert-an-integer-to-a-roman-numeral-integer-to-roman/
		return null;
	}

	private static int romanToInteger(String roman) {
		
		Integer sum = new Integer(0);
		
		if(roman == null || roman.length() < 1) return sum;
			
		char [] romanChars = roman.toCharArray();
		int len = romanChars.length;
		
		sum = romanMap.get(romanChars[len-1]);
		
		// traverse from back, starting from last but one element
		// at each step compare the current element with its successor
		// if less than subtract, else add
		for(int i = len-2; i>=0;i--){
			
			if(romanMap.get(romanChars[i+1])>romanMap.get(romanChars[i])){
				sum = sum - romanMap.get(romanChars[i]);
			} else {
				sum = sum + romanMap.get(romanChars[i]);
			}
		}
		
		return sum;
	}

}
