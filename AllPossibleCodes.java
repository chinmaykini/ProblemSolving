import java.util.ArrayList;
import java.util.List;

public class AllPossibleCodes {
	
	
	public static void main(String args[]){
		String inputString = "1123";
		System.out.println(" All possible string : "+allPosStrings(inputString));
		
		String inputString2 = "26";
		System.out.println(" All possible string : "+allPosStrings(inputString2));
		
		String inputString3 = "261";
		System.out.println(" All possible string : "+allPosStrings(inputString3));
		
		String inputString4 = "123";
		System.out.println(" All possible string : "+allPosStrings(inputString4));
	}

	private static List<String> allPosStrings(String inputString) {
		List<String> result = new ArrayList<String>();
		allPosStringsInt(inputString,result,"",0);
		return result;
	}

	private static void allPosStringsInt(String inputString, List<String> result,
										 String prefix,int index) {
		
		if( inputString.length()==0){
			result.add(prefix);
			return;
		}
		Integer currVal = inputString.charAt(0)-'0';
		allPosStringsInt(inputString.substring(1),result,prefix+getChar(currVal),index+1);
		if( inputString.length() >1){
			Integer val = Integer.parseInt(inputString.substring(0,2));
			if( val <= 26 )
			allPosStringsInt(inputString.substring(2),result,prefix+getChar(val),index+2);
		}
	}
	
	static char getChar(int val){
		return (char) ('a'+val-1);
	}
	
	

}
