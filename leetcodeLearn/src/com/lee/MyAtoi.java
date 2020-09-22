package com.lee;

public class MyAtoi {


	public static void main(String[] args) {
		System.out.println(myAtoi("   +0 123"));
	}

	public static int myAtoi(String str) {
		char[] chars = str.toCharArray();
		int result = 0;
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				if (s.length() == 0) {
					continue;
				} else {
					break;
				}
			}
			if ((chars[i] == '+' && s.length() == 0) ||
					(chars[i] == '-' && s.length() == 0) ||
					(chars[i] >= '0' && chars[i] <= '9')) {
				s.append(chars[i]);
			} else {
				break;
			}
		}
		System.out.println(s.toString());
		try {
			result = s.length() > 0 ? Integer.valueOf(s.toString()) : 0;
		} catch (NumberFormatException e) {
			if (s.length() > 1) {
				if (s.charAt(0) == '-') {
					result = Integer.MIN_VALUE;
				} else {
					result = Integer.MAX_VALUE;
				}
			} else {
				result = 0;
			}
		}
		return result;
	}
}



