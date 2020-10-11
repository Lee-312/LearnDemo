package com.lee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class IsStraight {

	public static void main(String[] args) {
		isStraight(new int[]{});
	}

	public static boolean isStraight(int[] nums) {
		Set set = new HashSet();
		int minNum = 14, maxNum = -1;
		for (int num : nums) {
			if (num == 0) {
				continue;
			}
			if (set.contains(num)) {
				return false;
			}
			set.add(num);
			maxNum = Math.max(maxNum, num);
			minNum = Math.min(minNum, num);
		}
		return maxNum - minNum < 5;
	}
}
