package com.lee.JAVA编程思想.Part14_类型信息;

public class SweetShop {
	public static void main(String[] args) {
		new Candy();
		System.out.println("after new Candy()");
		try {
			Class.forName("com.lee.JAVA编程思想.Part14_类型信息.Gum");
			Class.forName("com.lee.JAVA编程思想.Part14_类型信息.Gum");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("after class.forName");
		new Cookie();
	}
}

class Candy {
	static {
		System.out.println("init Candy");
	}
}

class Gum {
	static {
		System.out.println("init Gum");
	}
}

class Cookie {
	static {
		System.out.println("init Cookie");
	}
}
