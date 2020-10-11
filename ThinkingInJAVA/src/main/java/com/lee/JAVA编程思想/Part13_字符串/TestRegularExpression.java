package com.lee.JAVA编程思想.Part13_字符串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {

	public static void main(String[] args) {

		String s = "abcabcabcdefabc";
		String[] regexs = new String[3];
		regexs[0] = "abc+";
		regexs[1] = "(abc)+";
		regexs[2] = "(abc{2,})";
		Pattern pattern = Pattern.compile(s);

		for (String regex : regexs) {
			Matcher matcher = pattern.matcher(regex);
			while (matcher.find()) {
				System.out.println("Match " + matcher.group() + " at positions" + matcher.start() + "-" + (matcher.end()- 1));
			}
		}


	}
}
