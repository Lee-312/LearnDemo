package com.lee;

public class CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(4));

	}

	public static String countAndSay(int n) {
		if (n == 1) {
			return "1";
		} else if (n == 2) {
			return "11";
		} else if (n == 3) {
			return "21";
		} else {
			StringBuffer tmp = new StringBuffer("1211");
			for (int i = 0; i < n; i++) {
				StringBuffer tmp1 = new StringBuffer();
				char[] chars = tmp.toString().toCharArray();
				int count = 1;
				for (int j = 0; j < chars.length - 1; j++) {
					if (chars[j] == chars[j + 1]) {
						count++;
					} else {
						tmp1.append(count).append(chars[j]);
					}
				}
				tmp = tmp1;
			}
			return tmp.toString();
		}
	}
}

