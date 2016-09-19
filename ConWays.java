
public class ConWays {

	public static void main(String args[]){
		//String definition = "B3/S23";
//		int iterations=4;
//		String[] initialState = 
//				{"       ", 
//				"       ", 
//				"   #   ", 
//				"  ###  ", 
//				"   #   ", 
//				"       ", 
//				"       "};
//		String[] initialState1= {
//				"       ", 
//				"  ###  ", 
//				"       ", 
//		};
		
		String definition= "B1357/S02468";
		String[] initialState= {"     ", 
			 "     ", 
			 "  #  ", 
			 "     ", 
			 "     "};
		int iterations= 7;
		ConWays cn = new ConWays();
		int numAlive=cn.ConwaysVariationsOfLife(definition, initialState, iterations);
		System.out.println("Num of ALive : "+numAlive);
	}

	int ConwaysVariationsOfLife(String definition, String[] initialState, int iterations) {

		boolean [][] board = new boolean[initialState.length][initialState[0].length()];
		init(board,initialState);
		print(board);
		System.out.println();
		boolean[][] boardCopy ;
		for( int iter=1;iter <=iterations;iter++){
			boardCopy=getNewState(board,definition);
			board=boardCopy;
			print(boardCopy);
			System.out.println();
		}

		print(board);

		return countAliveCells(board);
	}
	private void print(boolean[][] board) {
		for( int i =0; i < board.length;i++){
			for( int j=0; j< board[0].length;j++){
				if( board[i][j] ){
					System.out.print("#");
				}else{
					System.out.print(".");
				}
			}
			System.out.println();
		}

	}

	void init(boolean[][] board,String[] state){
		int row=0;
		for( String currRow : state){
			for( int col=0; col < currRow.length(); col++){
				board[row][col]=currRow.charAt(col) == '#';
			}
			row++;
		}
	}
	
	int[] parse (String str){
		int[] rule= new int[str.length()];
		for( int i=0; i <str.length(); i++){
			rule[i]= str.charAt(i)-'0';
		}
		return rule;
	}

	boolean[][] getNewState(boolean[][] board,String definition){

		String[] strList = definition.split("/");
		int[] liveCellRule= parse(strList[0].substring(1));
		int[] surviveCellRule =   parse(strList[1].substring(1));
		

		boolean[][] boardCopy  = new boolean[board.length][board[0].length];

		for( int i=0; i<board.length ; i++){
			for( int j=0; j < board[0].length ; j++){
				if( applyRule (board,i,j,liveCellRule,surviveCellRule)){
					boardCopy[i][j] =true;
				}else{
					boardCopy[i][j] =false;
				}
			}
		}
		return boardCopy;
	}

	// A cell is "Born" if it has exactly 3 neighbours, "Survives" if it has 2 or 3 living neighbours; it 
	// dies otherwise. The first number, or list of numbers, is what is required for a dead cell to be 
	// born. The second set is the requirement for a live cell to survive to the next generation. Hence 
	// "B6/S16" means "a cell 

	boolean exists ( int [] rule, int val){
		for( int i=0; i < rule.length;i++){
			if( rule[i] == val)
				return true;
		}
		return false;
	}
	boolean applyRule(boolean[][] board,int cellR,int cellC,int [] liveCellRule,int[] surviveCellRule){
		int[] rows = {-1, 0, 1};
		int[] cols = {-1, 0, 1};

		int numAliveNeigbors=0;
		int neighborR=0,neighborC=0;
		for( int i=0 ; i < rows.length ;i++){
			for( int j=0; j < cols.length; j++){
				if ( !( rows[i] ==0 && cols[j]==0) ){
				//if ( !( i ==0 && j==0) ){
					neighborR=((cellR+rows[i] % board.length)+board.length)%board.length;
					neighborC=((cellC+cols[j] % board[0].length)+board[0].length)%board[0].length; 
					//System.out.println(neighborR+", "+neighborC);
					numAliveNeigbors+=board[neighborR][neighborC]?1:0;
				}
			}

		}
		if( !board[cellR][cellC] && exists(liveCellRule,numAliveNeigbors) ){
			return true;
		}else{
			if( board[cellR][cellC] &&
				exists(surviveCellRule,numAliveNeigbors))	
				return true;
		}
		return false;
	}


	int countAliveCells(boolean[][] board){
		int sum=0;
		for( int i=0; i < board.length;i++){
			for(int j=0; j < board[0].length ; j++){
				sum+=board[i][j]?1:0;
			}
		}
		return sum;
	}
}
