package com.lee.图解算法数据结构.动态规划;

public class Fbi {

	public static void main(String[] args) {
		fib(10);
	}

	public static int fib(int n) {
		int a = 0, b = 1, sum;
		for (int i = 0; i < n; i++) {
			sum = (a + b) % 1000000007;
			a = b;
			b = sum;
		}

		return a;
	}

}
