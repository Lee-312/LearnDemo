package com.lee;

import java.util.Arrays;
import java.util.Collections;

public class LongestPalindrome {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abacab"));
	}

	public static String longestPalindrome(String s) {
		char[] chars = s.toCharArray();
		if (chars.length == 0) {
			return "";
		}
		if (chars.length == 1) {
			return s;
		}
		String re = s.charAt(0) + "";
		for (int i = 0; i < chars.length; i++) {
			for (int j = chars.length - 1; j > i; j--) {
				if (chars[i] == chars[j]) {
					String tmp1 = s.substring(i, j + 1);
					StringBuffer tmp2 = new StringBuffer(tmp1);
					if (tmp1.equals(tmp2.reverse().toString())) {
						re = re.length() > tmp1.length() ? re : tmp1;
						if ((i + j) > (chars.length / 2)) {
							return tmp1;
						}
					}
				}
			}
		}

		return re;
	}

}
