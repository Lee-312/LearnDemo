package com.lee.proxy.staticProxy;

public class StaticProxy implements Subject {
	// 实现目标对象
	private Subject subject;

	public StaticProxy(Subject subject) {
		this.subject = subject;
	}
	public void request(){
		System.out.println("PreProcess");
		subject.request();
		System.out.println("PostProcess");
	}

}
