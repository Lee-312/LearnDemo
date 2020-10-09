package com.lee.JAVA编程思想.Part11_持有对象;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AddingGroups {
	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		Integer[] moreInts = {6, 7, 8, 9, 10};
		collection.addAll(Arrays.asList(moreInts));

		Collections.addAll(collection, 11, 12, 13, 14, 15);
		Collections.addAll(collection, moreInts);

		List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
		list.set(1, 99);
		System.out.println(list.getClass()); // class java.util.Arrays$ArrayList
		//list.add(21);// Runtime error because the underlying array cannot be resized

		List<Integer> l1 = new ArrayList<>();
		l1.add(22);
		System.out.println(l1.getClass());// class java.util.ArrayList

		List<Integer> l2 = new ArrayList<>(list);
		l2.add(23);
		System.out.println(l2);
	}

}
