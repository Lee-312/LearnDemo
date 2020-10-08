package com.lee.JAVA编程思想.Part10_内部类;

public class DotThis {
	void f() {
		System.out.println(" DotThis.f() ");
	}

	public class Inner {
		public DotThis outer() {
			return DotThis.this;
		}
	}

	public Inner inner() {
		return new Inner();
	}

	public static void main(String[] args) {
		DotThis dot = new DotThis();
		DotThis.Inner inner = dot.inner();
		inner.outer().f();
	}
}
