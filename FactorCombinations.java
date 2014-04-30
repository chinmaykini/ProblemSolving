import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;


public class FactorCombinations {

	public static List<List<Integer>> solution = new LinkedList<List<Integer>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		getFactorCombinations(24,new LinkedList<Integer>());
		for(List<Integer> ele : solution){
			System.out.print(Arrays.toString(ele.toArray()));
		}

	}

	private static void getFactorCombinations(int num, List<Integer> prevPartSolution) {
		
		for(int i = num-1; i>1 ; i -- ){
			
			if(num%i ==0){
				int temp = num/i;
				List<Integer> currentFactors = new LinkedList<Integer>();
				currentFactors.addAll(prevPartSolution);
				currentFactors.add(i);
				currentFactors.add(temp);
				
				// add it to the main solution and if add was successfull recurse
				if(solution.add(currentFactors)){
					// it added the current list now , recursse on i, with temp included in pre part
					// the prePartsolution for that will be the
					List<Integer> newCurrentFactors = new LinkedList<Integer>();
					newCurrentFactors.addAll(prevPartSolution);
					//newCurrentFactors.add(i);// DO NOT Include this we recurse on this
					newCurrentFactors.add(temp);    
					getFactorCombinations(i,newCurrentFactors);
				}
			}
		}
		
	}

}
