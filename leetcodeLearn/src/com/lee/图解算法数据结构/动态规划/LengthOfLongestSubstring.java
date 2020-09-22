package com.lee.图解算法数据结构.动态规划;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LengthOfLongestSubstring {


	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("dvdf"));
	}

	public static int lengthOfLongestSubstring(String s) {
		List<Character> tmp = new ArrayList();
		int max = 0;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (tmp.contains(chars[i])) {
				max = Math.max(max, tmp.size());
				tmp.clear();
			}
			tmp.add(chars[i]);
		}
		return Math.max(max, tmp.size());
	}
}
