package com.lee.JAVA编程思想.Part17_容器深入研究;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import com.lee.Part15.Generator;

import cn.hutool.captcha.generator.RandomGenerator;


public class MapDataTest {

	public static void main(String[] args) {
		System.out.println(MapData.map(new Letters(), 11));
		System.out.println(MapData.map(new Letters(), new RandomGenerator(3)));
		System.out.println(MapData.map(new Letters(),"Pop"));
	}
}

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {
	private int size = 9;
	private int number = 1;
	private char letter = 'A';

	@Override
	public Pair<Integer, String> next() {
		return new Pair<>(number++, "" + letter++);
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			@Override
			public Integer next() {
				return number++;
			}

			@Override
			public boolean hasNext() {
				return number < size;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}


}
