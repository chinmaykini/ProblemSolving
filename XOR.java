
public class XOR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input = {1,2,3,4,1,2,3};
		System.out.println(findNonDupe(input));
	}
	
	public static int findNonDupe(int[] input){
		
		int result = 0;
		for(int i=0; i< input.length ; i++){
			result = result ^ input[i];
		}
		
		return result;
	}

}
