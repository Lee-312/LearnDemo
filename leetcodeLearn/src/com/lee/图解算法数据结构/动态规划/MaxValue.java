package com.lee.图解算法数据结构.动态规划;

public class MaxValue {

	public static void main(String[] args) {
		int[][] grid =
				{{1, 3, 1},
						{1, 5, 1},
						{4, 2, 1}};
		System.out.println(maxValue(grid));
	}

	public static int maxValue(int[][] grid) {
		/**
		 * dp[i][j] = grid[i][j], i=0, j=0
		 * dp[i][j] = grid[i][j]+dp[i][j-1], i=0, j!=0
		 * dp[i][j] = grid[i][j]+dp[i-1][j], i!=0, j=0
		 * dp[i][j] = grid[i][j]+max(dp[i-1][j],dp[i][j-1]), i !=0, j !=0
		 */
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if (i == 0 && j != 0) {
					grid[i][j] = grid[i][j] + grid[i][j - 1];
				}
				if (i != 0 && j == 0) {
					grid[i][j] = grid[i][j] + grid[i - 1][j];
				}
				if (i != 0 && j != 0) {
					grid[i][j] = grid[i][j] + Math.max(grid[i - 1][j], grid[i][j - 1]);
				}
			}
		}
		return grid[grid.length - 1][grid[grid.length - 1].length - 1];
	}

}
