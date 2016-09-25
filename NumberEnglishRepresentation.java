
public class NumberEnglishRepresentation {
	
	static String[] scale 		= {"", "thousand", "million", "billion"};
	static String[] subTwenty 	= {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", 
								   "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "ninteen", "twenty"};
	static String[] decade 		= { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	
	/*
	 * representation between 0 - 999
	 */
	public static String hundredsRep(int num, boolean and){
		
		StringBuilder sb = new StringBuilder();
		if(num < 0 || num > 999)
			return "Error";
		
		int subHundred = num % 100;
		int hundred = num /100;
		
		if(hundred > 0){
			sb.append(subTwenty[hundred]).append(" hundred");
			
			if(subHundred > 0){
				sb.append(" and ");
			}
		}
		
		if(subHundred > 0){
			
			int tens = subHundred / 10;
			int units = subHundred % 10;
			
			if(tens > 0){
				sb.append(decade[tens] + " ");
			}

			if(units > 0){
				sb.append(subTwenty[units] + " ");
			}
		}
		
		return sb.toString();
		
	}
	
	/* 
	 * above 999
	 */
	public static String intToEnglish(int value, boolean and){
		
		
		StringBuffer sb = new StringBuffer();
		int[] thousand 	= new int[scale.length];
		int index 		= 0;

		if(value < 0){
			sb.append("minus ");
		}
		
		while(value!=0){
			thousand[index] = Math.abs(value % 1000);
			value = value / 1000;
			index++;
		}
		
		while(--index > 0){
			sb.append(hundredsRep(thousand[index], true)).append(scale[index] + " " );
		}
		
		sb.append(hundredsRep(thousand[index], true));

		return sb.toString();
	}

	public static void main(String[] args) {
		
		System.out.println(hundredsRep(743, true));
		System.out.println(hundredsRep(8, true));
		System.out.println(hundredsRep(67, true));
		System.out.println(hundredsRep(999, true));
		System.out.println(hundredsRep(0, true));		// doest work
		System.out.println(hundredsRep(500, true));
		System.out.println(hundredsRep(80, true));
		System.out.println(intToEnglish(5000, true));
		System.out.println(intToEnglish(1000, true));
		System.out.println(intToEnglish(-50000, true));
		System.out.println(intToEnglish(55000, true));
		System.out.println(intToEnglish(55234, true));
		System.out.println(intToEnglish(5523004, true));

	}

}
