package com.lee.JAVA编程思想.Part17_容器深入研究;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
	static Map<Integer, String> m = new HashMap();

	static {
		m.put(0, "A");
		m.put(1, "B");
		m.put(2, "C");
		m.put(3, "D");
		m.put(4, "E");
		m.put(5, "F");
		m.put(6, "G");
		m.put(7, "H");
		m.put(8, "I");
	}

	public static void main(String[] args) {
		Map<Integer, String> map = new LinkedHashMap<>();
		map.putAll(m);
		System.out.println(map);


		// LRU（Least-recently-useed order）
		Map<Integer, String> m2 = new LinkedHashMap(16, 0.75f, true);
		m2.putAll(m);
		for (int i = 0; i < 6; i++) {
			m2.get(i);
		}
		System.out.println(m2);
		m2.get(0);
		System.out.println(m2);
	}
}
