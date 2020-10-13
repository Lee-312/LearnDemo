package com.lee.JAVA编程思想.Part17_容器深入研究;

import java.util.ArrayList;

import com.lee.Part15.Generator;

public class CollectionData<T> extends ArrayList<T> {
	public CollectionData(Generator<T> gen, int quantity) {
		for (int i = 0; i < quantity; i++) {
			add(gen.next());
		}
	}

	public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
		return new CollectionData<>(gen, quantity);
	}
}
