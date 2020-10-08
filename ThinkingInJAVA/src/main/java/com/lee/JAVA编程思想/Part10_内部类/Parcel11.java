package com.lee.JAVA编程思想.Part10_内部类;

public class Parcel11 {
	private static class ParcelContents implements Contents {
		private int i = 11;

		@Override
		public int value() {
			return 0;
		}
	}

	protected static class ParcelDestination implements Destination {
		private String label;

		private ParcelDestination(String label) {
			this.label = label;
		}

		@Override
		public String readLabel() {
			return label;
		}

		public static void f() { }
		static int x =10;
		static class AnotherLevel{
			public static void f(){};
			static int x=10;
		}
	}
	public static Destination destination(String s){
		return new ParcelDestination(s);
	}

	public static Contents contents(){
		return new ParcelContents();
	}

	public static void main(String[] args) {
		Contents contents = contents();
		Destination destination = destination("Tasmania");
	}

}

