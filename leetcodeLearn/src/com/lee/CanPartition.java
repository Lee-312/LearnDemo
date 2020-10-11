package com.lee;

import java.util.Arrays;
import java.util.Collections;

public class CanPartition {
	public static void main(String[] args) {
		canPartition(new int[]{});

	}

	public static boolean canPartition(int[] nums) {
		int n = nums.length;
		// 判断数组是否可以被划分
		if (n < 2) {
			return false;
		}
		int maxNum = nums[0], sum = 0;
		for (int num : nums) {
			sum += num;
			maxNum = Math.max(maxNum, num);
		}
		// 判断数组和是否是2的倍数
		if (sum % 2 != 0) {
			return false;
		}
		// 判断最大数是否大于sum/2
		int target = sum / 2;
		if (maxNum > target) {
			return false;
		}

		boolean[][] dp = new boolean[n][target + 1];
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}
		dp[0][nums[0]] = true;
		for (int i = 1; i < n; i++) {
			int num = nums[i];
			for (int j = 1; j <= target; j++) {
				if (j >= num) {
					dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n - 1][target];
	}


}
