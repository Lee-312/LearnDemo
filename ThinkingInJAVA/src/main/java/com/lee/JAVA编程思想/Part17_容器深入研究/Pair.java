package com.lee.JAVA编程思想.Part17_容器深入研究;

public class Pair<K, V> {
	public final K key;
	public final V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
}
