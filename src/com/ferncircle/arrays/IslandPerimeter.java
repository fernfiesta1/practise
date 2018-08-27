package com.ferncircle.arrays;

/**
 * 
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water. Grid cells are connected
 * horizontally/vertically (not diagonally). The grid is completely surrounded
 * by water, and there is exactly one island (i.e., one or more connected land
 * cells). The island doesn't have "lakes" (water inside that isn't connected to
 * the water around the island). One cell is a square with side length 1. The
 * grid is rectangular, width and height don't exceed 100. Determine the
 * perimeter of the island.
 * 
 * Example:
 * 
 * [[0,1,0,0], 
 * [1,1,1,0], 
 * [0,1,0,0], 
 * [1,1,0,0]]
 * 
 * Answer: 16 Explanation: The perimeter is the 16 yellow stripes in the image
 * below:
 * 
 * @author dbrit00s
 *
 */
public class IslandPerimeter {

	public int islandPerimeter(int[][] grid) {

		int[] sidesWithZeros = new int[4];
		
		for(int i=0; i< grid.length; i++){
			for(int j=0; j< grid[0].length; j++){
				int sides = 0;
				if(grid[i][j] == 1){
					
					//check if left side is water
					if(j-1 < 0 || grid[i][j-1] == 0){
						sides++;
					}
					//check if right is water
					if(j+1 >= grid[0].length ||grid[i][j+1] == 0){
						sides++;
					}
					
					//chceck if water on top
					if(i-1 < 0 || grid[i-1][j] == 0){
						sides++;
					}
					
					//check if water at the bottom
					if(i+1 >= grid.length || grid[i+1][j] == 0){
						sides++;
					}
						
				}
				
				if(sides > 0){
					sidesWithZeros[sides-1]++;
				}
				
			}
		}
		
		int perimeter=0;
		for(int i=0; i< sidesWithZeros.length; i++){
			int product = sidesWithZeros[i]*(i+1);
			perimeter = perimeter + product;
		}
		
		return perimeter;
	}
	
	

	public static void main(String[] args) {
		IslandPerimeter ip = new IslandPerimeter();
		
		int[][] grid = {  {0, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}  };
		
		System.out.println(ip.islandPerimeter(grid));

	}

}
