package com.lee.proxy.dynamicProxy;


public class SubjectImpl implements Subject {
	@Override
	public void request() {
		System.out.println("I am dealing the request");
	}
}
