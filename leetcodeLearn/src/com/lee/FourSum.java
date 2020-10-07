package com.lee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		int length = nums.length;
		if (nums == null || length < 4) {
			return list;
		}
		//排序
		Arrays.sort(nums);
		for (int i = 0; i < length - 3; i++) {
			//当前数据与后一位数据不能相同
			if (i > 0 && nums[i] == nums[i -1]) {
				continue;
			}
			//当前下标数及顺序后三位的和与target比较
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
				break;
			}
			//当前下标与数组中后三位组成，当前最大和与target比较
			if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
				continue;
			}
			for (int j = i + 1; j < length - 2; j++) {
				//当前数据与后一位数据不能相同
				if (j > i+1 && nums[j] == nums[j - 1]) {
					continue;
				}
				//当前下标数及顺序后三位的和与target比较
				if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
					break;
				}
				//当前下标与数组中后三位组成，当前最大和与target比较
				if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
					continue;
				}
				int left = j + 1, rigth = length - 1;
				while (rigth > left) {
					int sum = nums[i] + nums[j] + nums[left] + nums[rigth];
					if (sum == target) {
						list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[rigth]));
						// 去重
						while (rigth > left && nums[left] == nums[left + 1]) {
							left++;
						}
						while (rigth > left && nums[rigth] == nums[rigth - 1]) {
							rigth--;
						}

						left++;
						rigth--;
					} else if (sum < target) {
						left++;
					} else {
						rigth--;
					}
				}
			}
		}
		return list;
	}

	class Solution {
		public List<List<Integer>> fourSum(int[] nums, int target) {
			List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
			if (nums == null || nums.length < 4) {
				return quadruplets;
			}
			Arrays.sort(nums);
			int length = nums.length;
			for (int i = 0; i < length - 3; i++) {
				if (i > 0 && nums[i] == nums[i - 1]) {
					continue;
				}
				if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
					break;
				}
				if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
					continue;
				}
				for (int j = i + 1; j < length - 2; j++) {
					if (j > i + 1 && nums[j] == nums[j - 1]) {
						continue;
					}
					if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
						break;
					}
					if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
						continue;
					}
					int left = j + 1, right = length - 1;
					while (left < right) {
						int sum = nums[i] + nums[j] + nums[left] + nums[right];
						if (sum == target) {
							quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
							while (left < right && nums[left] == nums[left + 1]) {
								left++;
							}
							left++;
							while (left < right && nums[right] == nums[right - 1]) {
								right--;
							}
							right--;
						} else if (sum < target) {
							left++;
						} else {
							right--;
						}
					}
				}
			}
			return quadruplets;
		}
	}

}
