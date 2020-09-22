package com.lee;

import java.util.Arrays;

public class removeDuplicates {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{ 1, 1, 2, }));
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length > 0) {
			int c = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != nums[c]) {
					nums[++c] = nums[i];
				}
			}
			return c + 1;
		} else {
			return 0;
		}
	}
}
