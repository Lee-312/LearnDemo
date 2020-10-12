package com.lee.JAVA编程思想.Part14_类型信息;

public class SimpleProxyDemo {
	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}

	public static void consumer(Interface inter) {
		inter.doSomething();
		inter.somethingElse("bonobo");
	}
}

interface Interface {
	void doSomething();

	void somethingElse(String arg);
}

class RealObject implements Interface {
	@Override
	public void doSomething() {
		System.out.println("doSomething");
	}

	@Override
	public void somethingElse(String arg) {
		System.out.println("somethingElse" + arg);
	}
}

class SimpleProxy implements Interface {
	private Interface proyied;

	public SimpleProxy(Interface proyied) {
		this.proyied = proyied;
	}

	@Override
	public void doSomething() {
		System.out.println("SimpleProxy doSomething");
		proyied.doSomething();
	}

	@Override
	public void somethingElse(String arg) {
		System.out.println("SimpleProxy somethingElse" + arg);
		proyied.somethingElse(arg);
	}
}
