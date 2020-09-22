package com.lee;

public class Test {


	public static void main(String[] args) {
		long l = System.currentTimeMillis();
		printN1(10000);
		System.out.println(System.currentTimeMillis()-l);
	}

	private static void printN1(int i) {
		for (int i1 = 1; i1 <= i; i1++) {
			System.out.println(i1);
		}
	}

	private static void printN2(int i) {
		if (i > 2) {
			printN2(i - 1);
			System.out.println(i);
		}
	}
}
