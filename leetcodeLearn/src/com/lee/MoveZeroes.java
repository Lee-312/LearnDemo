package com.lee;

import java.util.Arrays;

public class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = new int[]{0, 1, 0, 3, 12};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void moveZeroes(int[] nums) {
		for (int i = 0, j = 0; i < nums.length + 1 - j; i++) {
			if (nums[i] != 0) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j++] = tmp;
			}

		}

	}
}
