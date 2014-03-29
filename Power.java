
public class Power {

	public static void main(String[] args) {
		
		System.out.println(powerSimple(2, 4));
		System.out.println(powerIterative(2, 4));
		System.out.println(powerSimpleEnhanced(2, 4));
		System.out.println(powerNegativeExp(2, -1));
		System.out.println(powerFloatAndNegative(0.1, -1));
	}

	/*
	 * Time complexity o(n)
	 */
	private static int powerSimple(int base, int exp) {

		if(exp==0) return 1;
		else if(exp%2 == 0)
			return powerSimple(base,exp/2) * powerSimple(base,exp/2);
		else
			return base * powerSimple(base,exp/2) * powerSimple(base,exp/2);		
	}
	
	/* iterative solution
	 * 
	 * Each iteration the base is incread by the square and the exp is reduced by half
	 */
	
	private static int powerIterative(int base, int exp) {

		int result = 1;
		while(exp > 0){
			if(exp == 1)
				result = result * base;
			exp = exp /2;
			base = base * base; 
		}

		return result;	
	}
	
	/*
	 * Time complexity O(logn) as we saved the reuslt 
	 * and used it for teh other half
	 */
	private static int powerSimpleEnhanced(int base, int exp) {

		if(exp==0) return 1;
		int temp = powerSimpleEnhanced(base,exp/2);
		if(exp%2 == 0)
			return temp * temp;
		else
			return base * temp * temp;		
	}
	
	/*
	 * Time complexity O(logn) as we saved the reuslt 
	 * and used it for teh other half
	 * Return type is double
	 * temp is double
	 * and for exp less that -1, base is divided 
	 */
	private static double powerNegativeExp(int base, int exp) {

		if(exp==0) return 1;
		
		// temp is double
		double temp = powerNegativeExp(base,exp/2);
		if(exp%2 == 0)
			return temp * temp;
		else{
			if(exp<1)
				// tricky case divide by base 
				return (temp*temp)/base;
			else
				return base * temp * temp;
		}
					
	}
	
	private static double powerFloatAndNegative(double base, int exp) {

		if(exp==0) return 1;
		
		// temp is double
		double temp = powerFloatAndNegative(base,exp/2);
		if(exp%2 == 0)
			return temp * temp;
		else{
			if(exp<1)
				// tricky case divide by base 
				return (temp*temp)/base;
			else
				return base * temp * temp;
		}
					
	}
	
	
}
