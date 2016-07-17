import java.io.*;
import java.util.*;

public class Enumoperations {




	public static void main(String[] args) {
		System.out.println("Hello World!");


		try{

			TESTFRUITFUNC testFruitFunction = new TESTFRUITFUNC();
			testFruitFunction.testrandomFruits();
		} catch(Exception E){
			System.out.println(E);   
		}

	}

	public enum Fruit {
		APPLE,
		BANANA,
		ORANGE,
		GRAPE,
		KIWI,
		STRAWBERRY,
		BLUEBERRY,
		WATERMELON,
		PEACH,
		PLUM
	}

	public interface PrettyPrintAccounting {

		/**
		 * Generate random list of Fruit objects.
		 * Size should be random within min and max.
		 * @param minSize Minimum size of returned list.
		 * @param maxSize Maximum size of returned list.
		 * @return Random list of Fruit objects.
		 */
		List<Fruit> randomFruits(int minSize, int maxSize);



		/**
		 * Count Fruit objects from 2 collections and print a sorted count of each Fruit.
		 * The format should be: "4 kiwi, 2 banana, 2 watermelon and 1 apple".
		 * The counts are sorted descending.
		 * Fruits with the same count should be sorted alphabetically.
		 * Notice the last 2 fruit counts are delimited by " and " as oppose to ", ".
		 * @param fruitsA Collection of Fruit objects.
		 * @param fruitsB Collection of Fruit objects.
		 * @return String of sorted Fruit counts.
		 */
		String printFruitCounts(Collection<Fruit> fruitsA, Collection<Fruit> fruitsB);
		//[APPLE, APPLE, PLUM], [APPLE, PLUM, PEACH]
		//"3 apple, 2 plum and 1 peach"

		/**
		 * Convert string of Fruit counts in the format provided by "printFruitCounts"
		 * into a list of Fruit objects containing the counts indicated by the string.
		 * @param fruitCounts String of Fruit counts in format provided by "printFruitCounts"
		 * @return List of Fruit objects.
		 */
		List<Fruit> getFruitsFromString(String fruitCounts);
		//[APPLE, APPLE, APPLE, PLUM, PLUM, PEACH]
	}

	public static class FRUITFUNC implements PrettyPrintAccounting{

		@Override
		public List<Fruit> randomFruits(int minSize, int maxSize) throws IllegalArgumentException{

			List<Fruit> fruitList = Arrays.asList(Fruit.values());
			List<Fruit> result = new ArrayList<Fruit>();

			if( minSize > maxSize){
				throw new IllegalArgumentException();
			}
			if(maxSize==0){
				return result;
			}

			int randomListSize = (int)Math.round(Math.random()*(maxSize - minSize)) + minSize;


			for(int i =0; i<randomListSize ; i++ ){
				int currentRandomIndex = (int) Math.round(Math.random()*randomListSize);
				result.add(fruitList.get(currentRandomIndex)); 
			}

			return result;

		}

		@Override
		public String printFruitCounts(Collection<Fruit> fruitsA, Collection<Fruit> fruitsB){

			TreeMap<String,Integer> result = new TreeMap<String,Integer>();


			// combine the collections into hashmap
			for(Fruit fruit : fruitsA){
				if(result.containsKey(fruit.name())){
					Integer currentFruitCount = result.get(fruit.name()) + 1;
					result.put(fruit.name(),currentFruitCount);
				}else{
					result.put(fruit.name(),1);
				}
			}

			for(Fruit fruit : fruitsB){
				if(result.containsKey(fruit.name())){
					Integer currentFruitCount = result.get(fruit.name()) + 1;
					result.put(fruit.name(),currentFruitCount);
				}else{
					result.put(fruit.name(),1);
				}
			}

			return "";

		}

		@Override
		public List<Fruit> getFruitsFromString(String fruitCounts){

			return new ArrayList<Fruit>();

		}



	}

	public static class TESTFRUITFUNC{

		public void testrandomFruits() throws Exception{

			FRUITFUNC fruitTest = new FRUITFUNC();

			try{
				List<Fruit> exceptionCAse = fruitTest.randomFruits(7,2);
			} catch(Exception E){

				System.out.println("correct exception");
			}

			// case of zero
			List<Fruit> zeroCase = fruitTest.randomFruits(0,0);
			if(zeroCase.size()>0){
				throw new Exception("zero case failed");   
			}

			// valid case
			List<Fruit> validCase = fruitTest.randomFruits(3,10);
			if(!(validCase.size()>=3  && validCase.size()<=10)){
				throw new Exception("zero case failed");   
			}


			System.out.println("Done with test testrandomFruits");


		}

	}

}
