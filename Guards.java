import java.util.LinkedList;
import java.util.Queue;

public class Guards {
	
	// x = wall
	// g = guard
	// b = blank that turns into guard with edit distance of one
	
	public static char[][] board ={ {'b','x','g'},
					  				{'x','b','b'},
					  				{'b','g','x'},
					  				{'x','b','b'}};
	
	public static Queue<Point> queue = new LinkedList<>();
	
	public static class Point{
		int x;
		int y;
		char value;
		public Point(int x, int y, char value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	
	public static int getMaxEditLevel(){

		// fill up the queue with 1st gen Guards
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] == 'g'){
					queue.add(new Point(i, j, 'g'));
				}
			}
		}


		int resultLevel = 0;
		
		// level pointers
		int currentLevelCount = queue.size();
		int nextLevelCount = 0;

		while(!queue.isEmpty()){
			
			currentLevelCount--;
			Point currentNode = queue.poll();
			
			int x = currentNode.x;
			int y = currentNode.y;
			
			// process neighbours
			// convert the b's add them to queue
			for(int i = -1; i < 2; i++){
				for(int j = -1; j < 2; j++){
					
					// look at left, top, right, bottom elements, rest skip
					if(Math.abs(i) == Math.abs(j)){
						continue;
					}
					
					if(inboundry(x+i,y+j) && board[x+i][y+j] == 'b'){
						
						// found a next gen blank to be converted to guard
						board[x+i][y+j] = 'g';
						nextLevelCount++;
						queue.add(new Point(x+i, y+j, 'g'));
						
					}		
				}
			}
			
			// if currentLevel is Over we have to mark the increase of next gen
			if(currentLevelCount == 0){
				currentLevelCount = nextLevelCount;
				nextLevelCount = 0;
				resultLevel++;
			}
			

		} // end of while

		return resultLevel;
	}

	// check if i and j are in boudary of the board
	private static boolean inboundry(int i, int j) {
		
		if(i > -1 && i < board.length && j> -1 && j < board[0].length){
			return true;
		}
		
		return false;
	}
		
	public static void main(String[] args) {
		
		System.out.println(getMaxEditLevel());
		printBoard();

	}

	private static void printBoard() {
		
		for(int i=0; i< board.length; i++){
			
			String line = "";
			for(int j=0; j< board[0].length; j++){
				line = line + board[i][j] + ",";
			}
			System.out.println(line);
		}
		
	}	
	
}

