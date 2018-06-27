package com.ferncircle.arrays;

import java.util.Arrays;

public class RowColumnZero {

	public void solution(int[][] input){
		
		int rows = input.length;
		int columns = input[0].length;
		boolean[] rowZero = new boolean[rows];
		boolean[] columnZero = new boolean[columns];
		
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				if(input[i][j] == 0){
					rowZero[i] = true;
					columnZero[j] = true;
				}
			}
		}
		
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				if(rowZero[i] || columnZero[j]){
					input[i][j] =0;
				}
			}
		}
		
		System.out.println(Arrays.deepToString(input));
		
		
	}
	public static void main(String[] args) {
		

		int[][] input = new int[4][3];
		
		input[0][0] = 1;
		input[0][1] = 1;
		input[0][2] = 1;
		input[1][0] = 1;
		input[1][1] = 0;
		input[1][2] = 1;
		input[2][0] = 1;
		input[2][1] = 1;
		input[2][2] = 0;
		input[3][0] = 1;
		input[3][1] = 1;
		input[3][2] = 1;
		
		RowColumnZero rcz = new RowColumnZero();
		rcz.solution(input);
		
	}

}
