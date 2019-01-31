package com.ferncircle.design;

public class TicTacToe {

	int[] rows;
	int[] cols;
	int diagonal;
	int antidiagonal;
	int size;
	public TicTacToe(int n) {
		rows = new int[n];
		cols = new int[n];
		size = n;

	}

	public int move(int row, int col, int player) {

		int toAdd = (player == 1)? 1: -1;

		rows[row] += toAdd;
		cols[col] += toAdd;
		if(row == col){
			diagonal += toAdd;
		}
		if(row + col == size-1){
			antidiagonal += toAdd;
		}

		if(size == Math.abs(rows[row]) || size == Math.abs(cols[col]) || size == Math.abs(diagonal) || size == Math.abs(antidiagonal)){
			return player;
		}

		return 0;

	}

	public static void main(String[] args) {
		
		TicTacToe ttt = new TicTacToe(3);
		ttt.move(0, 0, 1);
		ttt.move(0, 2, 2);
		ttt.move(2, 2, 1);
		ttt.move(1, 1, 2);
		ttt.move(2, 0, 1);
		ttt.move(1, 0, 2);
		ttt.move(2, 1, 1);

	}

}
