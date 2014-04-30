
public class PrimeFactors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		primeFactors(24);
	}

	private static void primeFactors(int num) {
		
		for(int i = 2; i<=num; i++){
			while(num%i==0){
				System.out.println(i );
				num = num /i;
			}
		}
		
	}

}
