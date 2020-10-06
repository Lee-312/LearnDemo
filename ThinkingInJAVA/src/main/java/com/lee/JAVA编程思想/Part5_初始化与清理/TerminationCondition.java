package com.lee.JAVA编程思想.Part5_初始化与清理;

public class TerminationCondition {
	public static void main(String[] args) {
		Book book = new Book(true);
		book.checkIn();
		new Book(true);
		System.gc();
	}


}
class Book {
	boolean checkOut = false;

	public Book(boolean checkOut) {
		this.checkOut = checkOut;
	}

	void checkIn() {
		checkOut = false;
	}

	@Override
	protected void finalize() {
		if (checkOut) {
			System.out.println("Error: check out");
		}
	}
}