public class PermutationString {

	public static char[] input = "car".toCharArray();

	public static void main(String[] args) {

		printPermutationSwap(0);
		System.out.println("-------------");
		printPermutationForLoop("", "car");

	}
	
	/* 
	 * Funtion to generate permutations
	 * This breaks teh currentChar adds it to the prefix 
	 * the string has all chars but the current char
	 */

	private static void printPermutationForLoop(String prefix, String word) {

		if (word.length() == 0)
			System.out.println(prefix);

		for (int i = 0; i < word.length(); i++) {
			Character current = word.charAt(i);
			
			printPermutationForLoop(prefix + current, 	word.substring(0, i) + 
														word.substring(i + 1, word.length()));
		}
	}

	/*
	 * Function to generate permutations using Swaps
	 */
	private static void printPermutationSwap(int index) {

		if (index == input.length - 1)
			System.out.println(input);

		for (int i = index; i < input.length; i++) {
			swap(i, index);
			printPermutationSwap(index + 1);
			swap(i, index);
		}
	}

	private static void swap(int a, int b) {
		Character tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}

}
