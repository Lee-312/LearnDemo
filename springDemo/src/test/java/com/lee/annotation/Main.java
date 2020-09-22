package com.lee.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Fruit(name = "Apple")
public class Main {

	/**
	 * RUNTIME注解调用路线
	 * JAVA为注解产生一个代理类，这个代理类包括一个AnnotationInvocationHandler成员变量
	 * AnnotationInvocationHandler有一个Map的成员变量，用来存储所有的注解的属性赋值
	 * 在程序中，调用注解接口的方法，将会被代理类接管，然后根据方法名字，到Map中拿取相应的Value并返回 
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

		Fruit fruit = Main.class.getAnnotation(Fruit.class);
		System.out.println(fruit.name());

		System.out.println(fruit.getClass().getName());

		System.out.println(fruit.getClass().getGenericInterfaces()[0]);

		InvocationHandler h = Proxy.getInvocationHandler(fruit);
		System.out.println(h.getClass().getName());


	}

}
