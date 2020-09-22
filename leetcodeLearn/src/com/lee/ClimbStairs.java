package com.lee;

public class ClimbStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(5));

	}

	public static int climbStairs(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

}
