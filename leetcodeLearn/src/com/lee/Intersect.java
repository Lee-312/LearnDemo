package com.lee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Intersect {

	public static void main(String[] args) {
		int[] digits = {4, 3, 2, 1, 9};
		int[] ints = plusOne(digits);
		System.out.println(Arrays.toString(ints));
	}

	public static int[] plusOne(int[] digits) {
		int tmp = 0;
		int[] newInt = new int[digits.length + 1];
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] + 1 == 10) {
				newInt[i] = 0;
				tmp = 1;
			} else {
				newInt[i] = digits[i];
				tmp = 0;
			}
		}
		return null;
	}

}
