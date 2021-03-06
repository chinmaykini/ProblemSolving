import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Find the missing number in the Arithmatic Progression and print it
 */

public class ArithmaticProgression {

	public static void main(String[] args) {

			// parsing the input
			String lineTotalNumCount = "5";
			String lineNumbers = "1 11 31 41 51";
	        int numCount = Integer.parseInt(lineTotalNumCount);
	    	String[] numStr = lineNumbers.split( " " );
	    	
	    	// calculating the progression using the sum of difference and the total num count
			int diffSum = 0;
   			for(int i = 1 ; i < numStr.length; i++){
				int curr = Integer.parseInt(numStr[i]);
				int prev = Integer.parseInt(numStr[i-1]);
				diffSum += curr-prev;
			}
			int expectedProgression = diffSum / numCount;
	        
			// finding the  missing number using expected preogression
			int counter=1;
			while(counter<numStr.length){
				int curr = Integer.parseInt(numStr[counter]);
				int prev = Integer.parseInt(numStr[counter-1]);
				int diff = curr-prev;
	            
				if( diff != expectedProgression){
					System.out.println(prev+expectedProgression);
					break;
				}
					
				counter++;
			}

	}

}
