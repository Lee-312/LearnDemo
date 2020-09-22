package com.lee.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class test1 {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
		System.out.println("反射成员变量_______________________________________");
		// 反射成员变量
		// getFields获取本来及父类所有的public字段
		// getDeclaredFields获取本类所有声明的字段
		A a = new A(20, "Tom");
		Class c = a.getClass();
		Field[] f1 = c.getFields();
		for (int i = 0; i < f1.length; i++) {
			System.out.println(f1[i].getName() + f1[i].get(a));
		}

		System.out.println("***************************************");
		Field[] f2 = c.getDeclaredFields();
		for (Field f : f2) {
			f.setAccessible(true);// private属性需要setAccessible
			System.out.println(f.getName() + f.get(a));
		}
		System.out.println("反射成员方法_______________________________________");
		// 反射成员方法
/*		B b = new B();
		Class c2 = b.getClass();
		Method[] me1 = c2.getMethods();
		for (Method method : me1) {
			if ("f1".equals(method.getName())) {
				method.invoke(c2, null);
			}
		}
		System.out.println("***************************************");
		Method[] me2 = c2.getDeclaredMethods();
		for (Method method : me2) {
			if ("f2".equals(method.getName())) {
				method.setAccessible(true);
				String re = method.invoke(c2, "abc").toString();
				System.out.println(re);
			}
		}*/
		System.out.println("构造函数_______________________________________");
		// 构造函数
		D d = new D();
		Class c3 = d.getClass();
		Constructor[] con1 = c3.getConstructors();
		for (Constructor con : con1) {
			if (con.getParameterCount() > 0) {
				// 有参构造函数
				D dd = (D) con.newInstance(100);
				dd.printNum();
			} else {
				// 无参构造函数
				D dd = (D) con.newInstance();
				dd.printNum();
			}
		}
		System.out.println("父类父接口_______________________________________");
		// 父类父接口
		Son son = new Son();
		Class c4 = son.getClass();
		Class father = c4.getSuperclass();
		System.out.println(father.getName());

		Class[] inters = c4.getInterfaces();
		for (Class inter : inters) {
			System.out.println(inter.getName());
		}

	}

}

class A {
	public int age;
	private String name;

	public A(int age, String name) {
		this.age = age;
		this.name = name;
	}
}

class B {
	public void f1() {
		System.out.println("B.f1...");
	}

	private String f2(String s) {
		System.out.println("B.f1...");
		return s;
	}

}

class D {
	private int num;

	public D() {
		this.num = 10;
	}

	public D(int num) {
		this.num = num;
	}

	public void printNum() {
		System.out.println(this.num);
	}
}

class Father {
}

class Son extends Father implements Cloneable, Comparable {

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}