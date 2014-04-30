/*
 * http://www.careercup.com/question?id=5675246111686656
 */
public class CoinFlip {

	public static void main(String[] args) {
		
		
		int[] arr = {1,1,0,1,0,0};
		System.out.println( flipIndex(arr));

	}

	private static int flipIndex(int[] A) {
		int n = A.length; 
	    int result = 0; 
	    for (int i = 0; i < n - 1; i++)
	    { 
	        if (A[i] == A[i + 1]) 
	            result = result + 1; 
	    } 
	    int r = 0; 
	    
	    // in teh case of 1,1,1,1,1,1 its must to flip a coin, if this case is missed answer is 1, where as with a flip you are
	    // going to a worse sitaution, a flip is madatory, hence this case to start from -1 when n has more than 2 element.
	    // since r is max of r and count , max(0,0) would give you no additions, the answer needs 1 subtract due to the unwanted flip
	    if(n > 1)
	        r = -1;
	    for (int i = 1; i < n-1; i++)
	    { 
	        int count = 0; 

	        // 0,0,0 you wouldnt want to change, hence count -- when the adjacent elemets are same
	        // 0,1,0 you would want to change and flipping 1, gives you 2 more adjacent hits, this is the best case for flip
	        // 0,1,1 you would think you would want to flip the middle one but wudntl help. 
	        // hence 2 if cases to check for i with i-1 as well as i+1
			if (A[i - 1] != A[i])
				count = count + 1;
			else
				count = count - 1;
			
			if (A[i + 1] != A[i])
				count = count + 1;
			else
				count = count - 1;
			
			// at the max u can chnage the exisiting count by 2
			// as only one swap is allowed, hence store is value in r
			// and reset count for the next loop
	        r = Math.max(r, count); 
	    } 
	    return result + r; 
	}

}
