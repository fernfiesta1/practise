/*package com.ferncircle.arrays;

import javax.crypto.spec.RC2ParameterSpec;

public class MatrixMultiplication {
	
	public int[][] multiply(int a[][], int b[][]){
		
		int aRows = a.length;
		int aCols = a[0].length;
		
		int bRows = b.length;
		int bCols = b[0].length;
		
		if(aRows != bCols){
			//throw Runtime exception.
		}
		
		int[][] result = new int[aRows][bCols];
		
		for(int i=0; i<aRows; i++){
			int sum = 0;
			for(int j=0; j< aCols; j++){
				int prod = a[i][j] * b[j][i];
				sum = sum + prod;
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/