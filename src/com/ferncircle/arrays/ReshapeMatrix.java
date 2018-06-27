package com.ferncircle.arrays;

import java.util.Arrays;

public class ReshapeMatrix {
	
	int currRow = 0;
	int currCol = 0;

	public int[][] matrixReshape(int[][] nums, int r, int c) {

		
		int rows = nums.length;
		int colums = nums[0].length;		
		int totalElements = rows*colums;
		
		int[][] result = new int[r][c]; 
		
		if(r*c != totalElements){
			return nums; 
		}		
		
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				result[i][j]=getElement(nums);
			}
		}
		return result;
	}
	
	public int getElement(int[][] nums){
		
		int element = nums[currRow][currCol];
		if(currCol<nums[0].length-1){
			currCol++;
		}else{
			currCol = 0;
			currRow++;
		}
		
		return element;
	}


	public static void main(String[] args) {

		System.out.println("Test successfull");
		int[][] nums = new int[2][3];
		nums[0][0]=1;
		nums[0][1]=2;
		nums[0][2]=3;
		nums[1][0]=4;
		nums[1][1]=5;
		nums[1][2]=6;
		

		ReshapeMatrix rm = new ReshapeMatrix();
		System.out.println(Arrays.deepToString(rm.matrixReshape(nums, 1, 6)));
	}

}
