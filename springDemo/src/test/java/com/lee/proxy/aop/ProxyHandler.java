package com.lee.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
	static String beforeMethod = "";
	static String afterMethod = "";
	private Person object;

	public ProxyHandler(Person object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//处理before方法
		if (beforeMethod != null && beforeMethod.length() > 0) {
			ClassLoader c1 = ProxyHandler.class.getClassLoader();
			Class<?> c = c1.loadClass(object.getClass().getName());
			Method m = c.getMethod(beforeMethod);
			Object obj = c.newInstance();
			m.invoke(obj);
		}
		//处理目标方法
		Object result = method.invoke(object, args);
		//处理after方法
		if (afterMethod != null && afterMethod.length() > 0) {
			ClassLoader c1 = ProxyHandler.class.getClassLoader();
			Class<?> c = c1.loadClass(object.getClass().getName());
			Method m = c.getMethod(afterMethod);
			Object obj = c.newInstance();
			m.invoke(obj);
		}

		return result;
	}
}
