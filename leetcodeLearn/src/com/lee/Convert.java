package com.lee;

import java.util.ArrayList;
import java.util.List;

public class Convert {

	public static void main(String[] args) {
		System.out.println(convert("LEETCODEISHIRING", 3));
	}

	public static String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		List<StringBuilder> list = new ArrayList<>();
		for (int i = 0; i < Math.min(s.length(), numRows); i++) {
			list.add(new StringBuilder());
		}

		int rowNum = 0;// 目前位第几行
		boolean goDown = false;// 是否向下
		for (char c : s.toCharArray()) {
			list.get(rowNum).append(c);
			// 只有向上移动到顶或向下移动到底时，方向才会发生变化
			if (rowNum == 0 || rowNum == numRows - 1) {
				goDown = !goDown;
			}
			rowNum += goDown ? 1 : -1;
		}

		StringBuilder result = new StringBuilder();
		for (StringBuilder stringBuilder : list) {
			result.append(stringBuilder);
		}
		return result.toString();
	}
}
