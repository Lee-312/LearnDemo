package com.lee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

	public static void main(String[] args) {
		singleNumber1(new int[]{4, 1, 2, 1});
	}
	public static int singleNumber1(int[] nums) {
		int r = 0;
		for (int num : nums) {
			r ^= num;
		}
		return r;
	}
	public static int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == null) {
				map.put(nums[i], 1);
			} else {
				map.remove(nums[i]);
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue().equals(new Integer(1))){
				return entry.getKey();
			}
		}
		return 0;
	}
}
