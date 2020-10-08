package com.lee.JAVA编程思想.Part10_内部类;

public class Parcel5 {

	public Destination destination(String s) {
		class PDestination implements Destination {
			private String label;

			public PDestination(String label) {
				this.label = label;
			}

			@Override
			public String readLabel() {
				return label;
			}
		}
		return new PDestination(s);
	}


	public static void main(String[] args) {
		Parcel5 p = new Parcel5();
		Destination d = p.destination("Tasmania");
	}
}

