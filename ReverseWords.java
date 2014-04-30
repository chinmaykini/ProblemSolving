
public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String sentence = "My name is Chinmay";
		reverse_word(sentence.toCharArray());

	}


public static void reverse_word(char[] input) {

    int len = input.length;
    int wordBeginIndex = 0;
    
    if( len < 2 ) return;
      
    
    for( int i = 0 ; i < len ; i ++ )
    {
        if( input[i] == ' ' )
        {
            // word has finished
            // reverse it
            input = reverse( input, wordBeginIndex , i-1 );
            wordBeginIndex = i+1;
        }
        else if( i == len-1 )
        {
            // the sentence is complete
            input = reverse( input, wordBeginIndex, len-1 );
        }
        
    }
    // reverse teh whole string
    input = reverse( input , 0, len-1 );
    System.out.println("|" + new String(input) + "|");
}

public static char[] reverse( char[] input, int startIndex, int endIndex )
{
    while( startIndex < endIndex )
    {
        Character temp = input[endIndex];
        input[endIndex] = input[startIndex];
        input[startIndex]= temp;
        startIndex++;
        endIndex--;
    }
    return input;
}

}
