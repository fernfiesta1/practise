package com.ferncircle.recursionNdynamic;

public class UniquePathsII {
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int rows = obstacleGrid.length;
		int columns = obstacleGrid[0].length;
		int[][] resultGrid = new int[rows][columns];
		
		boolean obstacleFound = false;
		for(int i=0; i< rows; i++){
			if(obstacleGrid[i][0] == 1){
				obstacleFound = true;
			}
			
			if(obstacleFound){
				resultGrid[i][0] = 0;
			}else{
				resultGrid[i][0] = 1;
			}
		}
		
		obstacleFound = false;
		for(int i=0; i< columns; i++){
			if(obstacleGrid[0][i] == 1){
				obstacleFound = true;
			}
			
			if(obstacleFound){
				resultGrid[0][i] = 0;
			}else{
				resultGrid[0][i] = 1;
			}
		}
		
		for(int i=1; i< rows; i++){
			for(int j=1; j<columns; j++){				
				
				if(obstacleGrid[i][j] == 1){
					resultGrid[i][j] = 0;
				}else{
					resultGrid[i][j] = resultGrid[i-1][j] + resultGrid[i][j-1];
				}
				
			}
		}
		
		return resultGrid[rows -1 ][columns-1];
	}
	
	

}
