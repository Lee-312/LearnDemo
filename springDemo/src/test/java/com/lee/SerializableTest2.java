package com.lee;

import java.io.*;

public class SerializableTest2 {
	public static void main(String[] args) throws Exception {
		Ori o1 = Ori.o1;
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.txt"));
		out.writeObject(o1);
		out.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.txt"));
		// o2的值是Ori类型的全新的对象，它与如何预定义的常量都不等同，
		// 即使构造器是私有的，序列号机制也可以创建新的对象
		// 为解决这个问题，要定义readResolve的特殊序列化方法
		// 如果定义了readResolve方法，在对象被序列化后就会调用它，它必须返回一个对象，而该对象之后会成为readObject的返回值
		Ori o2 = (Ori) in.readObject();

		System.out.println(o1 == Ori.o1);
		System.out.println(o2 == Ori.o1);// 未定义readResolve方法前为false,定义后为true
	}
}

class Ori implements Serializable {
	public static final Ori o1 = new Ori(1);
	public static final Ori o2 = new Ori(2);

	private int value;

	public Ori(int value) {
		this.value = value;
	}

	/**
	 *
	 * @return
	 * @throws Exception
	 */
	protected Object readResolve() throws Exception {
		if (value == 1) return Ori.o1;
		if (value == 2) return Ori.o2;
		return null;
	}
}
