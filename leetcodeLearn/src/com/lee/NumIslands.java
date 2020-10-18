package com.lee;

import java.util.Arrays;

public class NumIslands {

	public static void main(String[] args) {
		char[][] grid = new char[][]{
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '1', '1'}
		};
		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {
		int islandNum = 0;
		int length = grid.length;
		int width = grid[0].length;

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				if (grid[i][j] == '1') {
					++islandNum;
					dfs(grid, i, j);
					System.out.println(Arrays.deepToString(grid));
					System.out.println();
				}

			}
		}
		return islandNum;
	}

	private static void dfs(char[][] grid, int i, int j) {
		int length = grid.length;
		int width = grid[0].length;
		if (i < 0 || j < 0 || i >= length || j >= width || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}

}
