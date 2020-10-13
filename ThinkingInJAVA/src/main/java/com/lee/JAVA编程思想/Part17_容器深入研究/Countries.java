package com.lee.JAVA编程思想.Part17_容器深入研究;

import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Countries {
	public static final String[][] DATA = {
			{"ALGERIA", "Algiers"},
			{"angola", "luanda"},
			{"AFGHANISTAN", "Kabul"},
			{"FIJI", "Suva"}
	};

	private static class FlyweigjtMap extends AbstractMap<String, String> {

		private static class Entry implements Map.Entry<String, String> {
			int index;

			public Entry(int index) {
				this.index = index;
			}

			@Override
			public boolean equals(Object o) {
				return DATA[index][0].equals(o);
			}

			@Override
			public String getKey() {
				return DATA[index][0];
			}

			@Override
			public String getValue() {
				return DATA[index][1];
			}

			@Override
			public String setValue(String s) {
				throw new UnsupportedOperationException();
			}

			@Override
			public int hashCode() {
				return DATA[index][0].hashCode();
			}
		}

		static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
			private int size;

			public EntrySet(int size) {
				if (size < 0) {
					this.size = 0;
				} else if (size > DATA.length) {
					this.size = DATA.length;
				} else {
					this.size = size;
				}
			}

			private class Iter implements Iterator<Map.Entry<String, String>> {
				private Entry entry = new Entry(-1);

				@Override
				public boolean hasNext() {
					return entry.index < size - 1;
				}

				@Override
				public Map.Entry<String, String> next() {
					entry.index++;
					return entry;
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}

				public Iterator<Map.Entry<String, String>> iterator() {
					return new Iter();
				}
			}

			@Override
			public Iterator<Map.Entry<String, String>> iterator() {
				return new Iter();
			}

			@Override
			public int size() {
				return size;
			}
		}

		private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);

		@Override
		public Set<Map.Entry<String, String>> entrySet() {
			return entries;
		}
	}

	static Map<String, String> select(final int size) {
		return new FlyweigjtMap() {
			@Override
			public Set<Map.Entry<String, String>> entrySet() {
				return new EntrySet(size);
			}
		};
	}

	static Map<String, String> map = new FlyweigjtMap();

	public static Map<String, String> capitals() {
		return map;
	}

	public static Map<String, String> capitals(int size) {
		return select(size);
	}

	static List<String> names = new ArrayList<>(map.keySet());

	public static List<String> names() {
		return names;
	}

	public static List<String> names(int size) {
		return new ArrayList<>(select(size).keySet());
	}

	public static void main(String[] args) {
		System.out.println(capitals(10));
		System.out.println(names(10));
		System.out.println(new HashMap<String, String>(capitals(3)));
		System.out.println(new LinkedHashMap<String,String>(capitals(3)));
		System.out.println(new TreeMap<String,String>(capitals(3)));
		System.out.println(new Hashtable<String,String>(capitals(3)));
		System.out.println(new HashSet<String>(names(6)));
		System.out.println(new LinkedHashSet<String>(names(6)));
		System.out.println(new TreeSet<String>(names(6)));
		System.out.println(new ArrayList<String>(names(6)));
		System.out.println(new LinkedList<String>(names(6)));
		System.out.println(capitals().get("BRAZIL"));
	}

}
