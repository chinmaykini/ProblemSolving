/*
 
Find minimum distance between two words (order preserved) in a big string. 
For e.g 1. "hello how are you" - distance between "hello" and "you" is 3. 
e.g 2. "hello how are hello you" - distance is 1 
e.g 3. "you are hello" - distance is -1. Order of "hello" and "you" should be preserved. 
e.g 4. "hello how are hello" - distance is -1 since "you" didnt occur even once.
*/

public class DistanceBetweenWords {

	public static void main(String[] args) {

		System.out.println( getMinDistance("hello how are you hello you", "hello", "you") );
        System.out.println(getMinDistance("hello how are you hello", "hello", "you"));
        System.out.println(getMinDistance("hello how are", "hello", "you"));
        System.out.println(getMinDistance("you are how hello", "hello", "you"));

	}

	private static Integer getMinDistance(String input, String word1,
			String word2) {

		int word1Ptr = Integer.MAX_VALUE, word2Ptr = Integer.MAX_VALUE;
		int minDistance = Integer.MAX_VALUE;
		int distance = 0;

		String[] inputArr = input.split(" ");
		for (int i = 0; i < inputArr.length; i++) {

			if (inputArr[i].equals(word1) || inputArr[i].equals(word2)) {
				if (inputArr[i].equals(word1)) {
					word1Ptr = i;
				} else{
					word2Ptr = i;
				}
				
				distance = word2Ptr - word1Ptr;
				if(Math.abs(minDistance)>=Math.abs(distance)){
					minDistance = distance;
				}
			}
		}
		
		if(minDistance>inputArr.length)
			return -1;

		return minDistance;

	}

}
