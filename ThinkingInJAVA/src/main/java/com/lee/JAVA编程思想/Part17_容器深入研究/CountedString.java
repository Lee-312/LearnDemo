package com.lee.JAVA编程思想.Part17_容器深入研究;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountedString {
	private String s;
	private int id = 0;
	private static List<String> created = new ArrayList<>();

	public CountedString(String s) {
		this.s = s;
		created.add(s);
		for (String s1 : created) {
			if (s1.equals(s)) {
				id++;
			}
		}
	}

	public static void main(String[] args) {
		Map<CountedString, Integer> map = new HashMap<>();
		CountedString[] cs = new CountedString[5];
		for (int i = 0; i < cs.length; i++) {
			cs[i] = new CountedString("hi");
			map.put(cs[i], i);
		}

		System.out.println(map);

		for (CountedString c : cs) {
			System.out.print("Lookong up " + c + "\t");
			System.out.print(map.get(c));
			System.out.println();
		}
	}

	@Override
	public int hashCode() {
		int result = 47;
		result = 37 * result + s.hashCode();
		result = 37 * result + id;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof CountedString &&
				s.equals(((CountedString) o).s) &&
				id == ((CountedString) o).id;
	}

	@Override
	public String toString() {
		return "String：" + s + "id：" + id + "hashCode：" + hashCode();
	}
}

