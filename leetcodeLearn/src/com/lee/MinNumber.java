package com.lee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinNumber {

	public static void main(String[] args) {
		minNumber(new int[]{3, 30, 34, 5, 9});
	}

	public static String minNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strs, (x, y) -> {
			return (x + y).compareTo(y + x);
		});
		StringBuffer str = new StringBuffer();
		for (String s : strs) {
			str.append(s);
		}
		return str.toString();
	}
}
