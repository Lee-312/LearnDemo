package com.lee.JAVA编程思想.Part10_内部类;

public class InheritInner extends WithInner.Inner {
	public InheritInner(WithInner wi) {
		wi.super();
	}

	public static void main(String[] args) {
		WithInner wi = new WithInner();
		InheritInner ii = new InheritInner(wi);
	}
}

class WithInner {
	class Inner {
	}
}
