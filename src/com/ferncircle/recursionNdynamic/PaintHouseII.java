package com.ferncircle.recursionNdynamic;

public class PaintHouseII {

	public int minCostII(int[][] costs) {

		int rows = costs.length;
		int cols = costs[0].length;
		int[][] dp = new int[rows][cols];

		int min1 = -1;
		int min2 = -1;

		// when there is only one house to be painted
		for (int i = 0; i < cols; i++) {
			dp[0][i] = costs[0][i];

			if (min1 == -1 || costs[0][i] < costs[0][min1]) {
				min2 = min1;
				min1 = i;

			} else if (min2 == -1 || costs[0][i] < costs[0][min2]) {
				min2 = i;
			}
		}

		for (int i = 1; i < rows; i++) {
			int tempMin1 = min1;
			int tempMin2 = min2;

			min1 = -1;
			min2 = -1;

			for (int j = 0; j < cols; j++) {
				if (tempMin1 != j) {
					dp[i][j] = dp[i - 1][tempMin1] + costs[i][j];
				} else {
					dp[i][j] = dp[i - 1][tempMin2] + costs[i][j];
				}

				if (min1 == -1 || costs[i][j] < costs[i][min1]) {
					min2 = min1;
					min1 = j;

				} else if (min2 == -1 || costs[i][j] < costs[i][min2]) {
					min2 = j;
				}
			}
		}

		return dp[rows - 1][min1];

	}

	public static void main(String[] args) {
		
		PaintHouseII ph = new PaintHouseII();
		int[][] costs = new int[][] { {8,7,1,8,17},
		                              {8,2,8,15,5},
		                              {8,17,1,15,3},
		                              {8,8,5,5,16},
		                              {2,2,18,2,9}};
		System.out.println(ph.minCostII(costs));

	}

}
