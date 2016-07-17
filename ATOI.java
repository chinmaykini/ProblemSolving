
public class ATOI {
	
	
	public static int atoi(String input){
		int result = 0;
		char[] arr = input.toCharArray();
		int index =0;
		// no number
		if(arr.length<0){
			return 0;
		}
		
		// -ve number
		boolean isNegative = arr[0] == '-' ? true :false;
		if(isNegative){
			index = 1;
		}
		
		for(int i=index; i<arr.length;i++){
			
			result = result*10 +  (arr[i ] - '0');
			
			// overflow 
			if(result<0){
				return 0;
			}
		}
		
		if(isNegative){
			return result*-1;
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(atoi("-2147483648"));
	}

}
