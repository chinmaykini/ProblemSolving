
import java.util.*;


public class BalancedParathesis {
	
	public static HashSet<Character> closingBraces = new HashSet<>();
	public static HashSet<Character> openingBraces = new HashSet<>();
	public static HashMap<Character, Character> braceMap = new HashMap<>();
	public static Stack<Character> braceStack = new Stack<>();
	
	static boolean isClosingBrace(Character brace){
		
		if(brace != null && closingBraces.contains(brace)){
			return true;
		}
		
		return false;
		
	}

	static boolean isOpeningBrace(Character brace){
		
		if(brace != null && openingBraces.contains(brace)){
			return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		System.out.println(hasBalancedBrackets("[](){}<>"));
		System.out.println(hasBalancedBrackets("([<{>}])"));

	}
	
	 static boolean hasBalancedBrackets(String s) {
		 
		buildBraceStore();
		
		if(s == null || s.isEmpty()){
			return true;
		}
		
		if(s.length()%2 > 0){
			return false;
		}

		char[] tokens = s.toCharArray();
		
		for(int i =0; i < tokens.length; i++){
			
			if(isOpeningBrace(tokens[i])){
				
				braceStack.push(tokens[i]);
			
			}else if(isClosingBrace(tokens[i])){
				
				if((braceStack.isEmpty()) || (braceStack.peek() != braceMap.get(tokens[i]))){
					return false;
				
				}else{
					braceStack.pop();
				}
				
			} else{
				continue;
			}
			
		}
		
		if(!braceStack.isEmpty()){
			return false;
		}
	    
		return true;
	 }
	 
	 static void buildBraceStore(){
		 
		 closingBraces.add(')');
		 closingBraces.add('}');
		 closingBraces.add(']');
		 closingBraces.add('>');
		 
		 openingBraces.add('(');
		 openingBraces.add('{');
		 openingBraces.add('[');
		 openingBraces.add('<');
		 
		 braceMap.put(')', '(');
		 braceMap.put('}', '{');
		 braceMap.put(']', '[');
		 braceMap.put('>', '<');
		 
	 }


}
