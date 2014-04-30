import java.util.HashMap;


public class IsomorphicWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isIsomorphic("foo","app"));
		System.out.println(isIsomorphic("bar","foo"));
		System.out.println(isIsomorphic("foo","boa"));
		System.out.println(isIsomorphic("turtle","tletur"));
		System.out.println(isIsomorphic("ab","ca"));

	}
	
	 public static boolean isIsomorphic(String firstWord, String secondWord) {
	   // implementation...
	   
	   if( firstWord.length() != secondWord.length() ) return false;
	   
	   // traverse mapping characters to their new onesin two maps
	   
	   HashMap<Character, Character> map1 = new HashMap<Character, Character>();
	   HashMap<Character, Character> map2 = new HashMap<Character, Character>();
	   
	   for(int i = 0; i < firstWord.length() ; i++){
	       Character ch1 = firstWord.charAt(i);
	       Character ch2 = secondWord.charAt(i);
	       if(map1.containsKey(ch1)){
	           if(map1.get(ch1) != ch2 ) return false;
	       }
	       if(map2.containsKey(ch2)){
	           if(map2.get(ch2) != ch1 ) return false;
	       }
	       map1.put(ch1,ch2);
	       map2.put(ch2,ch1);
	   
	   }
	   
	   return true;
	   
	 }

}
