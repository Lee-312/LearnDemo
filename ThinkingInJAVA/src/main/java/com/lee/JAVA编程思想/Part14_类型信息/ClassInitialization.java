package com.lee.JAVA编程思想.Part14_类型信息;

import java.util.Random;

public class ClassInitialization {
	public static Random rand = new Random(47);

	public static void main(String[] args) throws Exception {
		Class initable = Initable.class;
		System.out.println("after create Initable ref");
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staticFinal2);

		System.out.println(Initable2.staticNonFinal);
		Class initable3 = Class.forName("com.lee.JAVA编程思想.Part14_类型信息.Initable3");
		System.out.println("after create Initable3 ref");

		System.out.println(Initable3.staticNonFinal);
	}
}

class Initable {
	static final int staticFinal = 47;
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

	static {
		System.out.println("init Initable");
	}
}

class Initable2 {
	static int staticNonFinal = 147;
//	static final int staticNonFinal = 147;

	static {
		System.out.println("init Initable2");
	}
}

class Initable3 {
	static  int staticNonFinal = 74;

	static {
		System.out.println("init Initable3");
	}
}
