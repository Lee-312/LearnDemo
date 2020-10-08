package com.lee.JAVA编程思想.Part10_内部类;


public class Parcel8 {
	public Wrapping wraping(int x) {
		return new Wrapping(x) {
			@Override
			public int value() {
				return super.value() * 47;
			}
		};
	}

	public static void main(String[] args) {
		Parcel8 p = new Parcel8();
		Wrapping wraping = p.wraping(10);
		System.out.println(wraping.value());
	}
}

class Wrapping {
	private int i;

	public Wrapping(int i) {
		this.i = i;
	}

	public int value() {
		return i;
	}
}