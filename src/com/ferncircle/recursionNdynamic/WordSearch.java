package com.ferncircle.recursionNdynamic;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 * @author dbrit00s
 *
 */
public class WordSearch {

	public boolean exist(char[][] board, String word) {

		//Create a visited array
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		for(int i =0; i< board.length; i++){
			for(int j=0; j< board[0].length; j++){
				if(backtrack(board, visited, i, j, word, 0)){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean backtrack(char[][] board, boolean[][] visited, int i, int j, String word, int idx){
		
		if(idx == word.length()){
			return true;
		}
		
		if(i<0 || j<0 || i==board.length || j== board[0].length){
			return false;
		}
		
		if(board[i][j] != word.charAt(idx)){
			return false;
		}
		
		if(visited[i][j] == true){
			return false;
		}
		
		visited[i][j] = true;
		boolean exists = backtrack(board, visited, i-1, j, word, idx+1) ||
		backtrack(board, visited, i+1, j, word, idx+1)||
		backtrack(board, visited, i, j-1, word, idx+1)||
		backtrack(board, visited, i, j+1, word, idx+1);
		visited[i][j] = false;
		
		return exists;
		
	}
	public static void main(String[] args) {
		
		char[][] input = new char[][]{{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}};
			WordSearch ws = new WordSearch();
			System.out.println(ws.exist(input, "ABCCED"));

	}

}
