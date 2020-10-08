package com.lee.JAVA编程思想.Part7_复用类;

class Insect {
	private int i = 9;
	protected int j;

	public Insect() {
		System.out.println(" i= " + i + ", j= " + j);
		j = 39;
	}

	private static int x1 = printInit(" static Insect.x1 initiailzed");

	static int printInit(String s) {
		System.out.println(s);
		return 47;
	}
}


public class Beetle extends Insect {
	private int k = printInit(" Beetle.k initiailzed ");

	public Beetle() {
		System.out.println(" k= " + k);
		System.out.println(" j= " + j);
	}

	private static int x2 = printInit(" static beetle.x2 initiailzed");

	public static void main(String[] args) {
		System.out.println("Beetle construtor");
		Beetle beetle = new Beetle();
	}

}
