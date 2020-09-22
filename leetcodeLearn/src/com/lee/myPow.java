package com.lee;

public class myPow {

	public static void main(String[] args) {
		System.out.println(myPow(2.0, 10));
	}

	public static double myPow(double x, int n) {
		//Math.pow(x,n);
		if (n > 0) {
			double d = x;
			for (int i = 1; i < n; i++) {
				d *= x;
			}
			return d;

		} else if (n < 0) {
			double d = x;
			for (int i = 1; i < n; i++) {
				d *= x;
			}
			return 1 / d;
		} else {
			return 1;

		}

	}
}
