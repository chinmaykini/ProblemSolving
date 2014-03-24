
public class DutchNationalFlag {
	public static String[][] mainInput = new String[][] {
		{},
		{"r"},
		{"g"},
		{"b"},
		{"b","r"},
		{"g","r"},
		{"g","b","r"},
		{"g","r","r","g","r","r","g","r","b","g","r","r"},
		{"g","r","g","g","r","g","g","r","b","g","r","r"},
		{"g","r","g","g","r","g","b","r","b","g","r","r","b","r","g","g","b","g","g","r","b","g","r","r"},
		{"b","g"},
		{"r","g"},
		{"r","b"},
		{"r","r"},
		{"b","b"},
		{"g","g"},
		{"r","g","r","b","g","r","b","b","r"}
	};

	public static String [] input;

	public static void main(String[] args) {
		
		try {
			for(int j = 0; j < mainInput.length; j++){
				input = mainInput[j];
				dutchNationalFlag();
				printArray();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	private static void printArray() {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < input.length; i++){
			result.append(input[i]).append(",");
		}
		System.out.println(result.toString());
	}

	private static void dutchNationalFlag() throws Exception {
		
		int len = input.length;
		int redindex = -1;
		int blueindex = len;
		
		if(len < 1){
			System.out.println("Wrong input");
			return;
		}
		int i = 0;
		
		while(i<blueindex){
		
			if(input[i].equalsIgnoreCase("r")){
				redindex++;
				swap(i, redindex);
				i++;
			}else if(input[i].equalsIgnoreCase("b")){
				blueindex--;
				swap(i,blueindex);
			}else{
				i++;
			}

		}
	}

	private static void swap(int a, int b) {
		String tmp = input[a];
		input[a]= input[b];
		input[b] = tmp;
	}

}
