package com.lee;

import java.util.ArrayList;
import java.util.List;

public class RemoveElement {

	public static void main(String[] args) {
		generate(5);
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<>();
		int[][] arrs = new int[numRows][numRows];
		for (int i = 0; i < numRows; i++) {
			List<Integer> integerList = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					arrs[i][j] = 1;
				} else {
					arrs[i][j] = arrs[i - 1][j - 1] + arrs[i - 1][j];
				}
				integerList.add(arrs[i][j]);
			}
			list.add(integerList);
		}
		return list;
	}
}
