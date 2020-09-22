package com.lee;

public class ShortestPalindrome {
	public static void main(String[] args) {
		System.out.println(shortestPalindrome("aacecaaa"));
	}

	public static String shortestPalindrome(String s) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if (isPalindrome(str + s)) {
				return str + s;
			}
			str.append(s.charAt(i));
		}
		return s + s;
	}

	private static boolean isPalindrome(String s) {
		if (s.charAt(0) == s.charAt(s.length() - 1)) {//首位相同
			//区分奇偶
			int a, b;
			if (s.length() % 2 == 1) {
				a = s.length() / 2 - 1;
				b = s.length() / 2 + 1;

			} else {
				a = s.length() / 2 - 1;
				b = s.length() / 2;
			}
			while (a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b)) {
				a--;
				b++;
			}
			if (a == -1 && b == s.length() ) {
				return true;
			}
		}
		return false;
	}
}