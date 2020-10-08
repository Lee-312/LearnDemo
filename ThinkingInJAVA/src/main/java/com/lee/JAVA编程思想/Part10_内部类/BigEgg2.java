package com.lee.JAVA编程思想.Part10_内部类;

public class BigEgg2 extends Egg2 {
	public class Yolk extends Egg2.Yolk {
		public Yolk() {
			System.out.println(" BigEgg2.Yolk() ");

		}
		@Override
		public void f() {
			System.out.println(" BigEgg2.f() ");
		}
	}

	public BigEgg2() {
		insertYolk(new Yolk());
	}

	public static void main(String[] args) {
		Egg2 e = new BigEgg2();
		e.g();
	}
}

class Egg2 {
	protected class Yolk {
		public Yolk() {
			System.out.println(" Egg2.Yolk() ");
		}

		public void f() {
			System.out.println(" Egg2.f() ");
		}
	}

	private Yolk y = new Yolk();

	public Egg2() {
		System.out.println(" new Egg2() ");
	}

	public void insertYolk(Yolk yy) {
		this.y = yy;
	}

	public void g() {
		y.f();
	}
}
