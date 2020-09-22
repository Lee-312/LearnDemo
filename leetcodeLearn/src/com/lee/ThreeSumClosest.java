package com.lee;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

import org.omg.PortableInterceptor.INACTIVE;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums1 = new int[]{-1, 2, 1, -4}; //1
		int[] nums2 = new int[]{1, 1, -1, -1, 3}; //3

		System.out.println(threeSumClosest(nums2, 3));
	}


	public static int threeSumClosest(int[] nums, int target) {
		if (nums.length == 3) {
			return nums[0] + nums[1] + nums[2];
		}
		int sum = 0;
		TreeSet<Integer> set = new TreeSet();
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				for (int k = 0; k < nums.length; k++) {
					if (i == j || i == k || j == k) {
						continue;
					}
					sum = nums[i] + nums[j] + nums[k];
					if (sum == target) {
						return target;
					}
					set.add(sum);
				}
			}
		}
		System.out.println(set);

		int min = Integer.MAX_VALUE;
		int res = 0;
		for (int o : set) {
			if (min > Math.abs(target - o)) {
				min = Math.abs(target - o);
				res = o;
			}
		}
		return res;
	}
}
