package com.lee.Part15;

import java.util.Iterator;

interface Generator<T> {
	T next();
}

public class Fibonacci implements Generator<Integer> {
	private int count = 0;


	@Override
	public Integer next() {
		return fbi(count++);
	}

	private Integer fbi(int i) {
		if (i < 2) {
			return 1;
		}
		return fbi(i - 2) + fbi(i - 1);
	}

	public static void main(String[] args) {
		Fibonacci gen = new Fibonacci();
		for (int i = 0; i < 18; i++) {
			System.out.print(gen.next() + " ");
		}
	}
}

class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
	private int n;


	public IterableFibonacci(int n) {
		this.n = n;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			@Override
			public boolean hasNext() {
				return n > 0;
			}

			@Override
			public Integer next() {
				n--;
				return IterableFibonacci.this.next();
			}
		};
	}

	public static void main(String[] args) {
		for (Integer i : new IterableFibonacci(18)) {
			System.out.print(i+" ");
		}
	}
}
