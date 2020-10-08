package com.lee.JAVA编程思想.Part10_内部类;

public class LoadInnerClass {
	private int count = 0;

	Counter getCounter(final String name) {
		class LoadCounter implements Counter {
			public LoadCounter() {
				System.out.println(" new getCounter() ");
			}

			@Override
			public int next() {
				System.out.println(name);
				return count++;
			}
		}
		return new LoadCounter();
	}

	Counter getCounter2(final String name) {
		return new Counter() {
			{
				System.out.println(" new getCounter2() ");
			}

			@Override
			public int next() {
				System.out.println(name);
				return count++;
			}
		};
	}

	public static void main(String[] args) {
		LoadInnerClass lic = new LoadInnerClass();
		Counter c1 = lic.getCounter("local inner"),
				c2 = lic.getCounter2("anonymous inner");
		for (int i = 0; i < 5; i++) {
			System.out.println(c1.next());
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(c2.next());
		}
	}

}

interface Counter {
	int next();
}
