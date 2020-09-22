package com.lee.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

	public static void initXml() {
		XmlReader.readXml("G:/workSpaces/LearnDemo/springDemo/src/test/java/com/lee/learn/proxy/aop/aops.xml");
		ResourceListener.addListener("G:/workSpaces/LearnDemo/springDemo/src/test/java/com/lee/learn/proxy/aop");
	}

	public static void main(String[] args) throws Exception {
		Main.initXml();

		Person person = new PersonImpl();
		ProxyHandler handle = new ProxyHandler(person);
		ClassLoader loader = Main.class.getClassLoader();
		Class<?> clazz = Proxy.getProxyClass(loader, new Class<?>[]{Person.class});
		Person proxy = (Person) clazz.getConstructor(new Class[]{InvocationHandler.class}).newInstance(new Object[]{handle});
		while (true) {
			proxy.eat();
			Thread.sleep(3000);
		}
	}
}
