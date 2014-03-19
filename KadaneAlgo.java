public class KadaneAlgo {

	public static void main(String[] args) {

		int[] input = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int maxSoFar = Integer.MIN_VALUE, maxUntilNow = 0;
		int start = 0, end =0, startTemp=0;

		for (int i = 0; i < input.length; i++) {

			maxUntilNow += input[i];
			if (maxUntilNow < 0) {
				maxUntilNow = 0;
				startTemp=i+1;
			}
			if (maxSoFar <= maxUntilNow) {
				maxSoFar = maxUntilNow;
				start= startTemp;
				end = i;
			}
		}
		
		System.out.println("Max Sum : " +maxSoFar);
		System.out.println("Start index : " +start);
		System.out.println("End Index : " +end);
	}

}
