package com.lee.JAVA编程思想.Part7_复用类;

class Art {
	Art() {
		System.out.println("Art constructor");
	}
}

class Drawing extends Art {
	Drawing() {
		System.out.println("Drawing constructor");
	}

}

public class Cartoon extends Drawing {
	public Cartoon() {
		System.out.println("Cartoon constructor");
	}

	public static void main(String[] args) {
		Cartoon cartoon = new Cartoon();
	}
}
