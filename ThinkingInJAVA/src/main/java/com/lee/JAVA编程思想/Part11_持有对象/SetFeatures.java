package com.lee.JAVA编程思想.Part11_持有对象;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetFeatures {
	public static void main(String[] args) {
		Random random = new Random(47);
		Set<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < 1000; i++) {
			hashSet.add(random.nextInt(30)+ (1 << 16));
		}
		System.out.println(hashSet);

		Set<Integer> treeSet = new TreeSet<>();
		for (int i = 0; i < 1000; i++) {
			treeSet.add(random.nextInt(30)+ (1 << 16));
		}
		System.out.println(treeSet);

		Set<String> set = new HashSet<>();
		Collections.addAll(set, "A B C D E F G H I J K".split(" "));
		set.add("M");
		System.out.println("D：" + set.contains("D"));
		System.out.println("X：" + set.contains("X"));
		Set<String> set2 = new HashSet<>();
		Collections.addAll(set2, "H I J K".split(" "));
		System.out.println(set.containsAll(set2));
		set.removeAll(set2);
		System.out.println(set);
		Collections.addAll(set, "X Y Z".split(" "));
		System.out.println(set);
	}
}
