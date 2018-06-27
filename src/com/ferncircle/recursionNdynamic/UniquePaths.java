package com.ferncircle.recursionNdynamic;

public class UniquePaths {

	public int uniquePaths(int rows, int cols) {
		
		int[][] input = new int[rows][cols];
		
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				if(i==0 || j==0){
					input[i][j] = 1;
				}else{
					input[i][j] = input[i-1][j] + input[j-1][i];
				}
			}
		}
		
		return input[rows-1][cols-1];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
