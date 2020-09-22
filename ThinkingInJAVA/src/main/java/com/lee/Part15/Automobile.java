package com.lee.Part15;

public class Automobile {
}

class Holder1 {
	private Automobile a;

	public Holder1(Automobile a) {
		this.a = a;

	}

	Automobile get() {
		return a;
	}

}

//使用泛型前
class Holder2 {
	private Object a;

	public Holder2(Object a) {
		this.a = a;

	}

	public Object getA() {
		return a;
	}

	public void setA(Object a) {
		this.a = a;
	}

	public static void main(String[] args) {
		Holder2 h2 = new Holder2(new Automobile());
		Automobile a = (Automobile) h2.getA();
		h2.setA("No an Automobile");
		String s = (String) h2.getA();
		h2.setA(1);
		Integer x = (Integer) h2.getA();
	}
}

//使用泛型后
class Holder3<T> {
	private T a;

	public Holder3(T a) {
		this.a = a;
	}

	public T getA() {
		return a;
	}

	public void setA(T a) {
		this.a = a;
	}

	public static void main(String[] args) {
		Holder3<Automobile> h2 = new Holder3(new Automobile());
		Automobile a = h2.getA();
		//h2.setA("No an Automobile");
		//h2.setA(1);
	}
}

