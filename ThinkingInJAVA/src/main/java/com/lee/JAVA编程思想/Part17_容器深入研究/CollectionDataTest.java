package com.lee.JAVA编程思想.Part17_容器深入研究;

import java.util.LinkedHashSet;
import java.util.Set;

import com.lee.Part15.Generator;

public class CollectionDataTest {

	public static void main(String[] args) {
		// 使用构造器
		Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Government(), 15));
		// 使用方法
		//set.addAll(CollectionData.list(new Government(), 15));
		System.out.println(set);
	}
}


class Government implements Generator<String> {
	String[] foundation = ("strange women lying in ponds distributing swords is no basis for a system of government").split(" ");
	private int index;

	@Override
	public String next() {
		return foundation[index++];
	}
}
