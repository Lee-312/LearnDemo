package com.lee;

import java.util.HashMap;
import java.util.Map;

public class NumSpecial {


	public static void main(String[] args) {
		int[][] mat =
				{{0, 0, 0, 0, 0},
						{1, 0, 0, 0, 0},
						{0, 1, 0, 0, 0},
						{0, 0, 1, 0, 0},
						{0, 0, 0, 1, 1}};
		System.out.println(numSpecial(mat));
	}

	public static int numSpecial(int[][] mat) {
		int count = 0;
		Map map = new HashMap<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 1) {
					int k = i;
					int m = j;
					while (mat[i][m++] == 0 && mat[k++][m] == 1
							&& k < mat.length && m < mat[i].length) {

					}

				}
			}
		}


		return count;
	}
}
