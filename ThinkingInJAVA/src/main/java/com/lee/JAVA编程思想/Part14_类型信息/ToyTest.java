package com.lee.JAVA编程思想.Part14_类型信息;

public class ToyTest {
	static void printInfo(Class zz) {
		System.out.println("Class name" + zz.getName() + " is interface " + zz.isInterface());
		System.out.println("Simple name " + zz.getSimpleName());
		System.out.println("Canonical name " + zz.getCanonicalName());
	}

	public static void main(String[] args) {
		Class c = null;

		try {
			c = Class.forName("com.lee.JAVA编程思想.Part14_类型信息.FancyToy");
		} catch (ClassNotFoundException e) {
			System.out.println("FancyToy create failed");
			e.printStackTrace();
		}
		printInfo(c);
		for (Class face : c.getInterfaces()) {
			printInfo(face);
		}
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		printInfo(obj.getClass());

	}

}

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
	public Toy() {
	}

	public Toy(int i) {
	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
	public FancyToy() {
		super(1);
	}
}
