package com.lee;

import java.util.HashMap;
import java.util.Map;

public class CanPartition {
	public static void main(String[] args) {
		canPartition(new int[]{});

	}


	//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
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


	public static class MajorityElement {
		public static void main(String[] args) {
			System.out.println(majorityElement(new int[]{3, 2, 3}));
		}

		public static int majorityElement(int[] nums) {
			Map<Integer, Integer> map = new HashMap();
			for (int num : nums) {
				map.put(num, map.getOrDefault(num, 0)+1);
			}
			int result = -1;
			int len = nums.length;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() > (len / 2)) {
					result = entry.getKey();
				}
			}
			return result;
		}
	}
}
