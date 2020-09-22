package com.lee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MyHashSet {


	public static void main(String[] args) {

		int[][] matrix =
				{
						{1, 4, 7, 11, 15},
						{2, 5, 8, 12, 19},
						{3, 6, 9, 16, 22},
						{10, 13, 14, 17, 24},
						{18, 21, 23, 26, 30}
				};

		System.out.println(findNumberIn2DArray(new int[][]{{}}, 5));
	}


	public static boolean findNumberIn2DArray(int[][] matrix, int target) {
		if (matrix.length <= 0) {
			return false;
		}
		if (matrix[0].length <= 0) {
			return false;
		}
		for (int i = 0; i < matrix.length; i++) {
			if (target == matrix[i][0] || target == matrix[i][matrix[i].length - 1]) {
				return true;
			}
			if (target > matrix[i][0] && target < matrix[i][matrix[i].length - 1]) {
				int left = 0;
				int right = matrix[i].length - 1;
				int middle = (left + right) / 2;
				while (right >= left && right > -1 && left > -1) {
					if (matrix[i][middle] > target) {
						//比关键字大则关键字在左区域
						right = middle - 1;
					} else if (matrix[i][middle] < target) {
						//比关键字小则关键字在右区域
						left = middle + 1;
					} else {
						return true;
					}
					middle = (left + right) / 2;
				}
			}
		}
		return false;
	}


}

