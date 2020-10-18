package com.lee;

import java.util.HashMap;
import java.util.Map;

public class SortedSquares {

	public static void main(String[] args) {
		sortedSquares(new int[]{-4, -1, 0, 3, 10});
	}

	public static int[] sortedSquares(int[] A) {
		int left = 0, right = A.length - 1, index = A.length - 1;
		int[] newA = new int[A.length];
		while (right > left) {
			int leftValue = A[left] * A[left];
			int rightValue = A[right] * A[right];
			if (rightValue >= leftValue) {
				newA[index--] = rightValue;
				right--;
			} else {
				newA[index--] = leftValue;
				left++;
			}
		}
		return newA;
	}

	public int[] sortedSquares2(int[] A) {
		int n = A.length;
		int[] ans = new int[n];
		for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
			if (A[i] * A[i] > A[j] * A[j]) {
				ans[pos] = A[i] * A[i];
				++i;
			} else {
				ans[pos] = A[j] * A[j];
				--j;
			}
			--pos;
		}
		return ans;
	}

}
