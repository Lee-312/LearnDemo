package com.lee.JAVA编程思想.Part13_字符串;

import java.util.Arrays;

public class Splitting {
	private static String knights = "Then, when you have found the shrubbery , you must cut down the mightiest tree in th forset ... with ... a herring!";

	public static void split(String regex) {
		System.out.println(Arrays.toString(knights.split(regex)));
	}

	public static void main(String[] args) {
		split(" ");
		split("\\W+");
		split("n\\W+");
	}

}
