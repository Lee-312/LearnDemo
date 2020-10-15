package com.lee.JAVA编程思想.Part17_容器深入研究;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap<K, V> extends AbstractMap {

	public static void main(String[] args) {
		SimpleHashMap<String, String> m = new SimpleHashMap<>();
		m.putAll(Countries.capitals(5));
		System.out.println(m);
		System.out.println(m.get("ERITREA"));
		System.out.println(m.entrySet());
	}

	static final int SIZE = 997;
	LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

	@Override
	@SuppressWarnings("unchecked")
	public V put(Object key, Object value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null) {
			buckets[index] = new LinkedList<MapEntry<K, V>>();
		}
		LinkedList<MapEntry<K, V>> bucket = buckets[index];
		MapEntry<K, V> pair = new MapEntry(key, value);
		boolean found = false;

		ListIterator<MapEntry<K, V>> iterator = bucket.listIterator();
		while (iterator.hasNext()) {
			MapEntry<K, V> next = iterator.next();
			if (next.getKey().equals(key)) {
				oldValue = next.getValue();
				iterator.set(pair);
				found = true;
				break;
			}

		}
		if (!found) {
			buckets[index].add(pair);
		}
		return oldValue;
	}

	@Override
	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null) {
			return null;
		}
		for (MapEntry<K, V> pair : buckets[index]) {
			if (pair.getKey().equals(key)) {
				return pair.getValue();
			}
		}
		return null;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Entry<K, V>>();
		for (LinkedList<MapEntry<K, V>> bucket : buckets) {
			if (bucket == null) {
				continue;
			}
			for (MapEntry<K, V> pair : bucket) {
				set.add(pair);
			}
		}
		return set;
	}
}

class MapEntry<K, V> implements Map.Entry<K, V> {
	private K key;
	private V value;

	public MapEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V v) {
		V result = value;
		value = v;
		return result;
	}

	@Override
	public int hashCode() {
		return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof MapEntry)) {
			return false;
		}
		MapEntry me = (MapEntry) o;
		return (key == null ? me.getKey() == null : key.equals(me.getKey())) &&
				(value == null ? me.getValue() == null : value.equals(me.getValue()));
	}

	@Override
	public String toString() {
		return key + " = " + value;
	}
}