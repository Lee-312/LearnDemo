package com.lee.JAVA编程思想.Part12_通过异常处理错误;

public class WhoCalled {
	public static void main(String[] args) {
		f();
		System.out.println("-------------");
		g();
		System.out.println("-------------");
		h();
	}

	static void f() {
		try {
			throw new Exception();
		} catch (Exception e) {
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element);
			}
		}
	}

	static void g() {
		f();
	}

	static void h() {
		g();
	}
}
