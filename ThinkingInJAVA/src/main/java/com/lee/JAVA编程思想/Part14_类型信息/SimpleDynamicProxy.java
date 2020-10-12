package com.lee.JAVA编程思想.Part14_类型信息;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {

	public static void consumer(Interface inter) {
		inter.doSomething();
		inter.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);

		Interface proxy = (Interface) Proxy.newProxyInstance(
				Interface.class.getClassLoader(),
				new Class[]{Interface.class},
				new DynamicPrroxyHandler(real));
		consumer(proxy);
	}
}

class DynamicPrroxyHandler implements InvocationHandler {

	private Object proxied;

	public DynamicPrroxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
		System.out.println("*** proxy" + o.getClass() + ", method: " + method + ", args: " + objects);
		if (objects != null) {
			for (Object obj : objects) {
				System.out.println(" " + obj);
			}
		}
		return method.invoke(proxied, objects);
	}
}
