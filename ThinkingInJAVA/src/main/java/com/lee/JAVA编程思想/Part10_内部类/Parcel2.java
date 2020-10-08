package com.lee.JAVA编程思想.Part10_内部类;

public class Parcel2 {
	class Contents {
		private int i;

		public int value() {
			return i;
		}
	}

	class Destination {
		private String label;

		public Destination(String label) {
			this.label = label;
		}

		public String readLabel() {
			return label;
		}
	}

	public Destination to(String s) {
		return new Destination(s);
	}

	public Contents contents() {
		return new Contents();
	}

	public void ship(String dest) {
		Contents c = contents();
		Destination d = to(dest);
		System.out.println(d.readLabel());
	}

	public static void main(String[] args) {
		Parcel2 p = new Parcel2();
		p.ship("Tasmania");
		Parcel2 p2 = new Parcel2();
		Parcel2.Contents c = p2.contents();
		Parcel2.Destination d = p2.to("Borneo");
	}

}
