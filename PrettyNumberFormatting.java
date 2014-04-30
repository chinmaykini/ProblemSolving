import java.text.DecimalFormat;


/*
 * 
 * Explaination:
 * 
 * Time Complexity : O(1) , beacuse there is a higher limit on 1G, the while loop will run 
 * at the most 3 times. So we can state the complexity of O(constant) = O(1)
 * 
 * Space Complexity : O(1) , using maps of size 3, because of teh higher limt of 1G its a constant
 */
public class PrettyNumberFormatting {
	
	// Map that stores the suffix
	public static final String[] byteMap = {"B", "K", "M", "G"};
	// map that is used to select the correct formatter for teh decimal numbers
	public static final String[] decimalFormatMap = {"0.##", "0.#", "0"};
	public static DecimalFormat dF;
	// assumption that 1000bytes = 1kb and so on
	public static final int offset = 1000;
	
	public static void main(String[] args) {

//		System.out.println(prettyNumberFormat(0));
		System.out.println(prettyNumberFormat(341));
		System.out.println(prettyNumberFormat(1000));
		System.out.println(prettyNumberFormat(341301));
		System.out.println(prettyNumberFormat(34130));
		System.out.println(prettyNumberFormat(34245));
		System.out.println(prettyNumberFormat(5916000));
		System.out.println(prettyNumberFormat(54123));
		System.out.println(prettyNumberFormat(1000000000));
//		
//		// The below two Cases are drawback of this approach
//		// 99.99 is rounded to 100, due to the decimal formatter
		System.out.println(prettyNumberFormat(999999999));
		System.out.println(prettyNumberFormat(9999));
			
	}

	/* 
	 * a function to convert an Integer representing a number of bytes (less than or equal to 1 Gigabyte) into an
	 * easy to read format 
	 * Maximum of 3 digits (not counting a decimal point), and a single letter to signify the unit of measure. 
	 * No leading zeroes, or trailing zeroes after a decimal point.
	 */
	private static String prettyNumberFormat(Integer bytes) {
		
		int count =0;
		
		Double byteDouble = bytes.doubleValue();
		
		while(byteDouble>=offset){
			byteDouble = byteDouble / offset;
			count ++;
		}

		// using the decimal formatter to remove the trailing zeros
		// the length of the integer number os used to select the decimal formatter
		dF = new DecimalFormat(decimalFormatMap[String.valueOf(byteDouble.intValue()).length()-1]);
		return dF.format(byteDouble)+byteMap[count];
	}


}
