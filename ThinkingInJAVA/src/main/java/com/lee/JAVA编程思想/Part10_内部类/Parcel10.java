package com.lee.JAVA编程思想.Part10_内部类;

public class Parcel10 {
	public Destination destination(final String dest, final float price) {
		return new Destination() {
			private int cost;

			{
				cost = Math.round(price);
				if (cost > 100) {
					System.out.println("Over budget!");
				}
			}

			private String label = dest;

			@Override
			public String readLabel() {
				return label;
			}
		};
	}

	public static void main(String[] args) {
		Parcel10 p = new Parcel10();
		Destination destination = p.destination("Tasmania",89.12F);
		Destination destination2 = p.destination("Tasmania",101.39F);
	}

}

