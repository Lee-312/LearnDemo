package com.lee;

public class FindMin {


	public static void main(String[] args) {

	}

	public static int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (right > left) {
			mid = (left + right) / 2;
			if (nums[mid] > nums[mid + 1]) {
				return nums[mid + 1];
			}
			if (nums[mid] > nums[right]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return nums[left];

/*
		int tmpMin = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < tmpMin) {
				return nums[i];
			}
		}
		return tmpMin;
*/
	}
}
