package com.ferncircle.arrays;


/**
 * 
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

solution:
In order to do this in place, we need to have 4 states
dead --> dead = 0
live --> live = 1
dead --> live = 2
live --> dead = 3

In first pass, assign appropriate states to each cell
In second pass, go through each state and make it dead or alive.


 * @author dbrit00s
 *
 */
public class GameOfLife {

	public void gameOfLife(int[][] board) {

		//In first pass, associate proper state to each cell
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				int alive = getAliveNumber(board, i, j);
				if(board[i][j] == 1 && (alive <2 || alive > 3)){
					//cell is dead due to under Populstion
					board[i][j] = 3;
				}else if (board[i][j] == 0 && alive == 3){
					//cell becomes alive again
					board[i][j] = 2;
				}
			}
		}

		//In second pass, chage states 2 and 3 to 1 and 0 respectively

		for(int i=0; i< board.length; i++){
			for(int j=0; j<board[0].length; j++){
				if(board[i][j] == 2){
					board[i][j] = 1;
				}else if(board[i][j] == 3){
					board[i][j] = 0;
				}
			}
		}

	}

	private int getAliveNumber(int[][] board, int i, int j){

		int aliveCnt = 0;
		int rows = board.length;
		int cols = board[0].length;
		//vertically up
		if((i-1 >= 0) && (board[i-1][j] == 1 || board[i-1][j] == 3)){
			aliveCnt++;
		}
		
		//vertically down
		if((i+1 < rows) && (board[i+1][j] == 1 || board[i+1][j] == 3)){
			aliveCnt++;
		}
		
		//horizontally left
		if((j-1 >= 0) && (board[i][j-1] == 1 || board[i][j-1] == 3)){
			aliveCnt++;
		}
		
		//horizontally right
		if((j+1 < cols) && (board[i][j+1] == 1 || board[i][j+1] == 3)){
			aliveCnt++;
		}
		
		//diagonal up left
		if((i-1 >= 0 && j-1 >= 0) && (board[i-1][j-1] == 1 || board[i-1][j-1] == 3)){
			aliveCnt++;
		}
		
		//diagonal down right
		if((i+1 < rows && j+1 < cols) && (board[i+1][j+1] == 1 || board[i+1][j+1] == 3)){
			aliveCnt++;
		}
		
		//diagonal up right
		if((i-1 >= 0 && j+1 < cols) && (board[i-1][j+1] == 1 || board[i-1][j+1] == 3)){
			aliveCnt++;
		}
		
		//diagonal down left
		if((i+1 < rows && j-1 >= 0) && (board[i+1][j-1] == 1 || board[i+1][j-1] == 3)){
			aliveCnt++;
		}

		return aliveCnt;
	}

	public static void main(String[] args) {
		

		GameOfLife gl = new GameOfLife();
		int[][] input = new int[][]{{1,1},
			{1,0}};
			
		gl.gameOfLife(input);
	}

}
