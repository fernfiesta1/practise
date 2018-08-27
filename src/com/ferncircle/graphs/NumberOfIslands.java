package com.ferncircle.graphs;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * Input: 11110 11010 11000 00000
 * 
 * Output: 1 Example 2:
 * 
 * Input: 11000 11000 00100 00011
 * 
 * Output: 3
 * 
 * @author dbrit00s
 *
 */
public class NumberOfIslands {

	public int numIslands(char[][] grid) {

		if (grid == null) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				count += dfs(i, j, grid);
			}
		}

		return count;
	}

	private int dfs(int row, int col, char[][] grid) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
			return 0;
		}

		grid[row][col] = '0';
		dfs(row - 1, col, grid);
		dfs(row + 1, col, grid);
		dfs(row, col - 1, grid);
		dfs(row, col + 1, grid);
		return 1;
	}

	public static void main(String[] args) {

		char[][] input = new char[][] { { '1', '1', '0', '0' }, { '1', '1', '0', '1' }, { '1', '1', '0', '0' },
				{ '0', '0', '0', '1' } };

		NumberOfIslands ns = new NumberOfIslands();
		System.out.println(ns.numIslands(input));
	}

}
