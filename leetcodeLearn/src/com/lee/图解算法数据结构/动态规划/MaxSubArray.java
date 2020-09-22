package com.lee.图解算法数据结构.动态规划;

public class MaxSubArray {
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-1, -2}));
	}


	public static int maxSubArray(int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			nums[i] += Math.max(nums[i - 1], 0);
			max = Math.max(nums[i], max);
		}
		return max;
	}

	public static int maxSubArray1(int[] nums) {
		if (nums.length < 2) {
			return nums[0];
		}
		int max = nums[0];
		int tmp = 0;
		for (int i = 0; i < nums.length; i++) {
			tmp += nums[i];
			if (tmp > max) {
				max = tmp;
			}
			if (tmp < 0) {
				tmp = nums[i] > 0 ? nums[0] : 0;
			}
		}
		return max;
	}
}



