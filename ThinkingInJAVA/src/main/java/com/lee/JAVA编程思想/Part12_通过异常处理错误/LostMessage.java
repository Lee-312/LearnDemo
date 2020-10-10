package com.lee.JAVA编程思想.Part12_通过异常处理错误;

public class LostMessage {
	public static void main(String[] args) {
		try {
			LostMessage l = new LostMessage();
			try {
				l.f();
			} finally {
				l.g();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void f() throws VeryimportException {
		throw new VeryimportException();
	}

	void g() throws HoHumException {
		throw new HoHumException();
	}
}

class VeryimportException extends Exception {
	@Override
	public String toString() {
		return " a very important exception ";
	}
}

class HoHumException extends Exception {
	@Override
	public String toString() {
		return " a trivial exception ";
	}
}
