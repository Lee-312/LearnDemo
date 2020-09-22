package com.lee;

import java.util.Arrays;
import java.util.HashSet;

public class IsValid {
	public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));

	}

	public static boolean isValid(String s) {
		char[] cs = s.toCharArray();
		if (cs.length != 0 && cs.length % 2 != 0) {
			return false;
		}
		StringBuffer ss = new StringBuffer();
		for (int i = 0; i < cs.length; i++) {
			switch (cs[i]) {
				case '(':
					ss.append("()");
					break;
				case '[':
					ss.append("[]");
					break;
				case '{':
					ss.append("{}");
					break;
				default:
					continue;
			}
		}
		if (ss.toString().length() == s.length()) {
			return true;
		} else {
			return false;
		}
	}

}
