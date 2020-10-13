package com.lee.JAVA编程思想.Part17_容器深入研究;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Lists {
	private static boolean b;
	private static String s;
	private static int i;
	private static Iterator<String> it;
	private static ListIterator<String> lit;

	public static void basicTest(List<String> a) {
		a.add(1, "x");
		a.add("x");
		a.addAll(Countries.names(4));
		a.addAll(3, Countries.names(4));
		b = a.contains("1");
		b = a.containsAll(Countries.names(4));
		s = a.get(1);
		i = a.indexOf("1");
		b = a.isEmpty();
		it = a.iterator();
		lit = a.listIterator();
		lit = a.listIterator(3);
		i = a.lastIndexOf("1");
		a.remove(1);
		a.remove("3");
		a.set(1, "y");
		a.retainAll(Countries.names(4));
		a.removeAll(Countries.names(4));
		i = a.size();
		a.clear();
	}

	public static void iterMotion(List<String> a) {
		ListIterator<String> it = a.listIterator();
		b = it.hasNext();
		b = it.hasPrevious();
		s = it.next();
		i = it.nextIndex();
		s = it.previous();
		i = it.previousIndex();
	}

	public static void iterManipulation(List<String> a) {
		ListIterator<String> it = a.listIterator();
		it.add("47");
		it.next();
		it.remove();
		it.next();
		it.set("47");
	}



}
