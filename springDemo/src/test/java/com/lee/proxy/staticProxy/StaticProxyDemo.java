package com.lee.proxy.staticProxy;

/**
 * 静态代理
 * 代理对象持有目标对象的句柄
 * 所有调用目标对象的方法，都调用代理对象的方法
 * 对每个方法，需要静态编码（理解简单，但代码繁琐）
 */
public class StaticProxyDemo {
	public static void main(String[] args) {
		//创建实际对象
		SubjectImpl subject = new SubjectImpl();
		//把实际对象封装到代理对象中
		StaticProxy proxy = new StaticProxy(subject);
		proxy.request();
	}

}
