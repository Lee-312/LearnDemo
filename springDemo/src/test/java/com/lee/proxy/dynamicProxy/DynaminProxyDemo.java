package com.lee.proxy.dynamicProxy;


import java.lang.reflect.Proxy;

public class DynaminProxyDemo {
	public static void main(String[] args) {
		//创建目标对象
		SubjectImpl subject = new SubjectImpl();
		//创建调用处理器对象
		ProxyHandler handler = new ProxyHandler(subject);
		//动态生成代理对象
		Subject proxySubject = (Subject) Proxy.newProxyInstance(SubjectImpl.class.getClassLoader(), SubjectImpl.class.getInterfaces(), handler);
		//客户端通过代理对象调用方法
		//本次调用将自动被代理处理器的invoke方法接收
		proxySubject.request();
		System.out.println(proxySubject.getClass().getName());
	}
}
