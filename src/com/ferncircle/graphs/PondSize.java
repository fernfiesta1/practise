package com.ferncircle.graphs;

import java.util.ArrayList;
import java.util.List;

public class PondSize {

	public List<Integer> getPondSizes(int[][] graph) {

		int rows = graph.length;
		int columns = graph[0].length;
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int count = dfs(i, j, graph);
				if(count != 0){
					result.add(count);	
				}
				
			}
		}

		return result;
	}

	private int dfs(int row, int col, int[][] graph){
		if(row < 0 || col < 0 || row >= graph.length || col >= graph[0].length || graph[row][col] == 1){
			return 0;
		}
		graph[row][col] = 1;
		return 1 + 
				dfs(row-1, col, graph) + 
				dfs(row+1, col, graph) + 
				dfs(row, col-1, graph) + 
				dfs(row, col+1, graph) + 
				dfs(row-1, col-1, graph) +
				dfs(row+1, col-1, graph) +
				dfs(row-1, col+1, graph)+
				dfs(row+1, col+1, graph);
		
		
	}

	public static void main(String[] args) {

		PondSize ps = new PondSize();
		int[][] graph = new int[][]{
			{0,1,1,0},
			{0,1,0,1},
			{1,1,0,1},
			{0,1,0,1}
		};
		System.out.println(ps.getPondSizes(graph));
	}

}
