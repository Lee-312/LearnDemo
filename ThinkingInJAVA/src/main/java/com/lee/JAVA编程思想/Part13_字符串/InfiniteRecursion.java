package com.lee.JAVA编程思想.Part13_字符串;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {
	public static void main(String[] args) {
		List<InfiniteRecursion> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new InfiniteRecursion());
		}
		System.out.println(list);

	}

	@Override
	public String toString() {
//		return "InfiniteRecursion address" + this; //发生递归，产生StackOverflowError异常
		return super.toString();
	}
}
