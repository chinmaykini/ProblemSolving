import java.util.Arrays;

/*
 * Explaination : 
 * 
 * Time Complexity : O(n) , we have 3 for loops each running to the length of array
 * Space Complexity : O(n) , maintains 32 buffers of length n to keep track of products on the left side 
 * and right side. 
 */
public class ProductArray {

	public static void main(String[] args) {
		
		int[] input = {4,3,2,8};
		int[] result = productArray(input);
		System.out.println(Arrays.toString(result));
	}

	/*
	 * This fucntion given an array of integers, produce an array whose values are the product of every other integer 
	  excluding the current index. 
	 * Time complexity : O(n) , runs through the elemnts from i+1 to n
	 * Space Complexity : O(n) , maintian a buffer of products from i+1 to n
	 */
	private static int[] productArray(int[] input) {
		
		if(input == null || input.length<1) return null;
		
		int[] resultProductArray = new int[input.length];
		int[] leftProductArray = leftProductArray(input);
		int[] rightProductArray = rightProductArray(input);

		for(int i =0;i<input.length;i++){
			resultProductArray[i] = leftProductArray[i] * rightProductArray[i];
		}
		
		return resultProductArray;
	}

	/* 
	 * Function to calculate the left Product Array. 
	 * for any index location i in the array the value is product of element from o to i-1
	 * Time complexity : O(n) , runs through th eelemnts from 0 to i-1
	 * Space Complexity : O(n) , maitian a buffer of products from 0 - i-1
	 */
	private static int[] leftProductArray(int[] input) {
		int[] leftProductArray = new int[input.length];
		int product = 1;
		for(int i = 0; i < input.length ; i++){
			leftProductArray[i] = product;
			product *= input[i];
		}
		return leftProductArray;
	}

	/* 
	 * Function to calculate the right Product Array. 
	 * for any index location i in the array the value is product of element from i+1 to n
	 * Time complexity : O(n) , runs through the elemnts from i+1 to n
	 * Space Complexity : O(n) , maintian a buffer of products from i+1 to n
	 */
	private static int[] rightProductArray(int[] input) {
		int[] rightProductArray = new int[input.length];
		int product = 1;
		for(int i = input.length-1; i >= 0 ; i--){
			rightProductArray[i] = product;
			product *= input[i];
		}
		return rightProductArray;
	}

}
