import java.util.ArrayList;
import java.util.List;

/*
 * Given a list of arraylists containing elements, 
 * write a function that prints out the permutations of of the elements such that, 
 * each of the permutation set contains only 1 element from each arraylist and there are 
 * no duplicates in the list of permutation sets. 

Eg: consider the following lists 
L1= {a1,b1,c1,d1} 
L2={a2,b2,c2} 
L3= {a3, b3, c3} 

Valid Permutations are: 
{a1,b2,c3} 
{a1,a2,a3} 
{b1,c2,b3} 
... 
... 
.. 

Please note that 
{a1,b2,c3} is same set as {b2,a1,c3}
 */

public class PermutationsOfSet {

	static List<List<Character>> lists = new ArrayList<>();
	   
    private static void fillInput()
    {
        List<Character> l = new ArrayList<>();
        l.add('A');
        l.add('B');
        l.add('C');   
        lists.add(l);
        
        l = new ArrayList<>();
        l.add('1');
        l.add('2');
        l.add('3');
        lists.add(l);
        
        l = new ArrayList<>();
        l.add('a');
        l.add('b');
        l.add('c');
        lists.add(l);
    }
    
    public static void main(String[] args)
    {
        fillInput();
        generateCombo("", 0);
        System.out.println("Program finished");
    }
    
    private static void generateCombo(String prefix, int listIndex)
    {
        if(listIndex == lists.size() - 1)
        {
        	// the edge case, one but the last list
        	// append all the chars in the last list to the prefixes
            for(Character c : lists.get(listIndex))
                System.out.println(prefix + c);
        }
        else
        {
        	// for each char of current List recurse
            for(Character c : lists.get(listIndex))
                generateCombo(prefix + c, listIndex + 1);
        }
    }
}
