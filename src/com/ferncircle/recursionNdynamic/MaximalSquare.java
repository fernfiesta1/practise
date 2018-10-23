package com.ferncircle.recursionNdynamic;

public class MaximalSquare {


	public int maximalSquare(char[][] matrix) {


		int max = 0;
		int rows = matrix.length;		
		int columns = rows > 0?matrix[0].length:0; 

		//Note the +1. this is very important dp technique to handle edge cases. In this case to handle the corner row and column.
		int[][] result = new int[rows+1][columns+1];



		for(int i =1; i< result.length; i++){
			for(int j=1; j<result[0].length; j++){
				if(matrix[i-1][j-1] == '1'){
					result[i][j] = Math.min(Math.min(result[i-1][j], result[i-1][j-1]), result[i][j-1]) + 1;
					max = Math.max(max, result[i][j]);
				}

			}
		}

		return max*max;
	}
	public static void main(String[] args) {
		char[][] in = new char[][]{{'0'}};
		
		MaximalSquare ms = new MaximalSquare();
		System.out.println(ms.maximalSquare(in));

	}

}
