package com.lee.JAVA编程思想.Part9_接口;

public class Factories {
	public static void serviceConsumer(ServiceFactory factory) {
		Service s = factory.getService();
		s.method1();
		s.method2();
	}

	public static void main(String[] args) {
		serviceConsumer(new Implemeentation1Factory());
		serviceConsumer(new Implemeentation2Factory());
	}

}

interface Service {
	void method1();
	void method2();
}

interface ServiceFactory {
	Service getService();
}

class Implemeentation1 implements Service {

	@Override
	public void method1() {
		System.out.println(" Implemeentation1.method1() ");
	}

	@Override
	public void method2() {
		System.out.println(" Implemeentation1.method2() ");
	}
}

class Implemeentation1Factory implements ServiceFactory {
	@Override
	public Service getService() {
		return new Implemeentation1();
	}
}

class Implemeentation2 implements Service {
	@Override
	public void method1() {
		System.out.println(" Implemeentation2.method1() ");
	}

	@Override
	public void method2() {
		System.out.println(" Implemeentation2.method2() ");
	}
}

class Implemeentation2Factory implements ServiceFactory {
	@Override
	public Service getService() {
		return new Implemeentation2();
	}
}