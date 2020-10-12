package com.lee.JAVA编程思想.Part14_类型信息;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class SelectingMethods {
	public static void main(String[] args) {
		SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
				SomeMethods.class.getClassLoader(),
				new Class[]{SomeMethods.class},
				new MethodSelector(new Implementation())
		);
		proxy.boring1();
		proxy.boring2();
		proxy.interesting("bonobo");
		proxy.boring3();
	}

}

interface SomeMethods {
	void boring1();

	void boring2();

	void interesting(String arg);

	void boring3();

}

class Implementation implements SomeMethods {
	@Override
	public void boring1() {
		System.out.println("boring1");
	}

	@Override
	public void boring2() {
		System.out.println("boring2");

	}

	@Override
	public void interesting(String arg) {
		System.out.println("interesting " + arg);
	}

	@Override
	public void boring3() {
		System.out.println("boring3");

	}
}

class MethodSelector implements InvocationHandler {
	private Object proxied;

	public MethodSelector(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
		if (method.getName().equals("interesting")) {
			System.out.println("Proxy detected the interesting method");
		}
		return method.invoke(proxied, objects);
	}
}