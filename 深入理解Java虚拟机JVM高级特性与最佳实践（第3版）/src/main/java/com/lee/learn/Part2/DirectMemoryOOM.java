package com.lee.learn.Part2;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * 本机直接内存溢出
 * 直接内存：通过-XX:MaxDirectMemorySize来设置。如果不指定则默认与堆最大值一致
 * 直接内存导致的内存溢出，一个明显的特征是Dump文件不会有明显的异常情况，而dump文件又很小，而程序又直接或间接使用了DirectMemory
 */
public class DirectMemoryOOM {

	private static final int int_1MB = 1024 * 1024;

	//java.lang.OutOfMemoryError
	public static void main(String[] args) throws IllegalAccessException {
		Field field = Unsafe.class.getDeclaredFields()[0];
		field.setAccessible(true);
		Unsafe unsafe = (Unsafe) field.get(null);
		while (true) {
			unsafe.allocateMemory(int_1MB);
		}
	}

}
