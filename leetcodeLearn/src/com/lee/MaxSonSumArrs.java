package com.lee;

public class MaxSonSumArrs {

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}

	public static int maxSubArray(int[] nums) {
		int sum = 0;
		int tmp = Integer.MIN_VALUE;
		for (int num : nums) {
			if (sum > 0) {
				sum += num;
			} else {
				sum = num;
			}
			tmp = Math.max(sum, tmp);
		}
		return tmp;
	}
}
