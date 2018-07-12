package com.ferncircle.arrays;


/**
 * WWrite an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.

Solution:
Start from the upper right corner.
compare the element:
	if equal to target, return true.
	if element is less than target, increment row;
	else, decrement column;

 * @author dbrit00s
 *
 */
public class Search2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {

		int row = matrix.length;
		if(row == 0){
			return false;
		}
		int column = matrix[0].length;

		int i =0;
		int j = column -1;
		while(i< row && j>=0){
			if(matrix[i][j] == target){
				return true;
			}

			if(matrix[i][j] < target){
				i++;
			}else{
				j--;
			}
		}
		return false;
	}
	
	

	public static void main(String[] args) {
		Search2DMatrix sd = new Search2DMatrix();

		/*int[][] mat = new int[][]{ {10, 20, 30, 40},
				{15, 25, 35, 45},
				{27, 29, 37, 48},
				{32, 33, 39, 50}};*/
		
		int[][] mat = new int[][]{{10, 20, 30, 40},
			{15, 25, 35, 45}};

		System.out.println(sd.searchMatrix(mat, 50));

	}

}
