package com.lee.JAVA编程思想.Part10_内部类;

public class Parcel9 {
	public Destination destination(final String dest) {
		return new Destination() {
			private String label = dest;

			@Override
			public String readLabel() {
				return label;
			}
		};
	}

	public static void main(String[] args) {
		Parcel9 p = new Parcel9();
		Destination destination = p.destination("Tasmania");
		System.out.println(destination.readLabel());
	}

}

