package com.lee.JAVA编程思想.Part17_容器深入研究;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Unsuported {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("A B C D E F G H I J".split(" "));
		test("Modifiable", new ArrayList<>(list));
		test("Arrays.asList()", list);
		test("unmodifiableList()", Collections.unmodifiableList(new ArrayList<>(list)));
	}

	static void test(String msg, List<String> list) {
		System.out.println("------------- " + msg + " -------------");
		Collection<String> c = list;
		Collection<String> sublist = list.subList(1, 8);
		Collection<String> c2 = new ArrayList<>(sublist);

		try {
			c.retainAll(c2);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			c.clear();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			c.add("X");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {

			c.addAll(c2);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			c.remove("C");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			list.set(0, "X");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
