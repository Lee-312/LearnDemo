package com.lee.JAVA编程思想.Part14_类型信息;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ShowMethods {
	public static void main(String[] args) {

		try {
			Class<?> c = Class.forName("com.lee.JAVA编程思想.Part14_类型信息.ShowMethods");

			System.out.println("method list ");
			Method[] methods = c.getMethods();
			for (Method method : methods) {
				System.out.println(method);
			}

			System.out.println("constructor list ");
			Constructor<?>[] constructors = c.getConstructors();
			for (Constructor<?> constructor : constructors) {
				System.out.println(constructor);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
