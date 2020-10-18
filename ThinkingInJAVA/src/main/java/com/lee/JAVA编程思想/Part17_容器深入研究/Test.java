package com.lee.JAVA编程思想.Part17_容器深入研究;

public abstract class Test<C> {
	String name;

	public Test(String name) {
		this.name = name;
	}

	abstract int test(C Container, TestParam tp);
}
