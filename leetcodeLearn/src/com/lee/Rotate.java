package com.lee;

import java.util.Arrays;

public class Rotate {


	public static void main(String[] args) {
		rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
	}

	public static void rotate(int[] nums, int k) {
		int index = k;
		for (int i = 0; i < nums.length; i++) {
			int tmp = nums[index];
			nums[index] = nums[i];
			nums[i] = tmp;
			index++;
		}
		System.out.println(Arrays.toString(nums));

	}
}
