package com.ck.boggle;

import java.util.LinkedList;
import java.util.List;

import com.ck.dictionary.DictionaryImpl;

public class BoggleSolver {
	
	public DictionaryImpl dictionary = new DictionaryImpl();
	public List<String> result = new LinkedList<String>();
	boolean[][] visited ;
	public String[][] board =  { 	{"b","a","n"},
									{"r","c","v"},
									{"b","a","t"} 	};

	
	public BoggleSolver() {
	}
	
	public void printResult(){
		System.out.println("result");
		for(int i = 0; i <= result.size()-1; i++){
			System.out.println(result.get(i).toString());
		}
	}
	
	public void solver(){
		
		int m = board.length;
		int n = board[0].length;
		visited = new boolean[board.length][board[0].length];
		
		for(int i = 0; i<= m-1; i++){
			for( int j = 0; j <= n-1; j++){
				System.out.println("Working for |" + board[i][j] + "|");
				boggleSolver(board[i][j]+"", i, j);
			}
		}
		
		
		
	}

	 private void boggleSolver(String prefix, int row, int col) {

		 System.out.println("Prefix is " + prefix);
		 if(!dictionary.isValidPrefix(prefix)) return;
		 if(dictionary.isValidWord(prefix)) result.add(prefix);
		 
		 
		 
		 // top left
		 // row-1, col-1
		 if(0<= row-1 && 0<= col-1 && !visited[row-1][col-1]){
			 visited[row-1][col-1] = true;
			 System.out.println("Visited " + board[row-1][col-1]);
			 boggleSolver(prefix+board[row-1][col-1],row-1, col-1);
			 visited[row-1][col-1] = false;
		 }
		
		 // up
		 // row-1, col
		 if(0<= row-1 && 0<= col && !visited[row-1][col]){
			 visited[row-1][col] = true;
			 System.out.println("Visited " + board[row-1][col]);
			 boggleSolver(prefix+board[row-1][col],row-1, col);
			 visited[row-1][col] = false;
		 }
		 
	 
		 // top right
		 // row-1, col+1
		 if(0<= row-1 && col+1<= board[0].length-1 && !visited[row-1][col+1]){
			 visited[row-1][col+1] = true;
			 System.out.println("Visited " + board[row-1][col+1]);
			 boggleSolver(prefix+board[row-1][col+1],row-1, col+1);
			 visited[row-1][col+1] = false;
		 }
		 
		 // left
		 // row, col-1
		 if(0<= row && 0<= col-1 && !visited[row][col-1]){
			 visited[row][col-1] = true;
			 System.out.println("Visited " + board[row][col-1]);
			 boggleSolver(prefix+board[row][col-1],row, col-1);
			 visited[row][col-1] = false;
		 }
		 
		 // right 
		 // row, col+1
		 if(0<=row && col+1<= board[0].length-1 && !visited[row][col+1]){
			 visited[row][col+1] = true;
			 System.out.println("Visited " + board[row][col+1]);
			 boggleSolver(prefix+board[row][col+1],row, col+1);
			 visited[row][col+1] = false;
		 }
		 
		 
		 // left down
		 // row+1, col-1
		 if(row+1<= board.length-1 && 0<= col-1 && !visited[row+1][col-1]){
			 visited[row+1][col-1] = true;
			 System.out.println("Visited " + board[row+1][col-1]);
			 boggleSolver(prefix+board[row+1][col-1],row+1, col-1);
			 visited[row+1][col-1] = false;
		 }
		 
		 // down
		 // row+1, col
		 if(row+1<= board.length-1 && 0<=col && !visited[row+1][col]){
			 visited[row+1][col] = true;
			 System.out.println("Visited " + board[row+1][col]);
			 boggleSolver(prefix+board[row+1][col],row+1, col);
			 visited[row+1][col] = false;
		 }
		 
		 
		 // right down
		 // row+1, col+1
		 if(row+1<= board.length-1 && col+1<= board[0].length-1 && !visited[row+1][col+1]){
			 visited[row+1][col+1] = true;
			 System.out.println("Visited " + board[row+1][col+1]);
			 boggleSolver(prefix+board[row+1][col+1],row+1, col+1);
			 visited[row+1][col+1] = false;
		 }
		 

	}

}
