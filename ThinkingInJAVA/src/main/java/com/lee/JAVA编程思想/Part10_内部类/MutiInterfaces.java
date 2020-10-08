package com.lee.JAVA编程思想.Part10_内部类;

public class MutiInterfaces {
	static void tasksA(A a) {
	}

	static void tasksB(B b) {
	}
	static void tasksD(D d) {
	}

	static void tasksE(E e) {
	}
	public static void main(String[] args) {
		X x = new X();
		Y y = new Y();
		tasksA(x);
		tasksA(y);
		tasksB(x);
		tasksB(y.makeB());

		Z z = new Z();
		tasksD(z);
		tasksE(z.makeE());
	}
}

interface A {
}

interface B {
}

class X implements A, B {
}

class Y implements A {
	B makeB() {
		return new B() {
		};
	}
}

class D{}
abstract class E{
}
class Z extends D{
	E makeE(){
		return new E(){};
	}
}