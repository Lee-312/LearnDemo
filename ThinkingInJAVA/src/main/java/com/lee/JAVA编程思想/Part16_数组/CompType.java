package com.lee.JAVA编程思想.Part16_数组;

import java.util.Comparator;
import java.util.Random;

import javax.annotation.Generated;

import com.lee.Part15.Generator;

public class CompType implements Comparator<CompType> {
	int i, j;
	private static int count = 1;

	public CompType(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public String toString() {
		String result = "[i= " + i + ",j=" + j + "]";
		if (count++ % 3 == 0) {
			result += "\\n";
		}
		return result;
	}

	public int compareTo(CompType rv) {
		return (i < rv.i ? -1 : (i == rv.i ? 0 : i));
	}

	private static Random rand = new Random(47);
	public static Generator<CompType> generator(){
		return new Generator<CompType>() {
			@Override
			public CompType next() {
				return new CompType(rand.nextInt(100), rand.nextInt(100));
			}
		};
	}

	public static void main(String[] args) {
	}

	@Override
	public int compare(CompType compType, CompType t1) {
		return 0;
	}
}
