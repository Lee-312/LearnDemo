package com.lee.JAVA编程思想.Part10_内部类;

public class Parcel3 {
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


	public static void main(String[] args) {
		Parcel3 p = new Parcel3();
		Parcel3.Contents c = p.new Contents();
		Parcel3.Destination d = p.new Destination("Tasmania");
	}

}
