package com.lee;

public class SortColors {
	public static void main(String[] args) {
		sortColors(new int[]{2, 0, 2, 1, 1, 0});
	}

	public static void sortColors(int[] nums) {
		int red = 0, white = 0, blue = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				red++;
			} else if (nums[i] == 1) {
				white++;
			} else {
				blue++;
			}
		}

		int index = 0;
		while (red-- > 0) {
			nums[index++] = 0;
		}
		while (white-- > 0) {
			nums[index++] = 1;
		}
		while (blue-- > 0) {
			nums[index++] = 2;
		}
	}
}
