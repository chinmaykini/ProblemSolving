import java.util.*;

public class CombinationsAlphabet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String word = "121";
		combinationAlphabetHelper(new LinkedList<String>(), 0, word.toCharArray());

	}
	
	public static void combinationAlphabetHelper(List<String> result, int index, char[] word){
		
		if(index >= word.length){
			printResult(result);
			return;
		}
		
		Character currentChar = word[index];
		
		result.add(currentChar.toString());
		combinationAlphabetHelper(result, index+1, word);
		result.remove(result.size()-1);
		if((index <= word.length-2) && (word[index+1] == '1' ||  word[index+1] == '2') ){
			Character nextChar = word[index+1];
			result.add(currentChar.toString() + nextChar.toString());
			combinationAlphabetHelper(result, index+2, word);
			result.remove(result.size()-1);
		}
		
	}

	private static void printResult(List<String> result) {
		
		StringBuffer res = new StringBuffer();
		
		for(String word:result){
			res.append(word + ",");
		}
		
		System.out.println(res.toString());
	}

}
