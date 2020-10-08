package com.lee.JAVA编程思想.Part8_多态;

public class Derived extends PrivateOverride {
	public void f() {
		System.out.println(" public f() ");
	}
}

class PrivateOverride {
	private void f() {
		System.out.println(" private f() ");
	}

	public static void main(String[] args) {
		PrivateOverride po = new Derived();
		po.f();
	}
}
