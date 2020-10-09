package com.lee.JAVA编程思想.Part11_持有对象;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListIteration {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		ListIterator<Integer> iterator = list.listIterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + ", " + iterator.nextIndex() + ", " + iterator.previousIndex() + "; ");
		}
		System.out.println();

		while (iterator.hasPrevious()) {
			System.out.print(iterator.previous() + " ");
		}
		System.out.println();
		System.out.println(list);

		while (iterator.hasNext()){
			iterator.next();
			iterator.set(new Random().nextInt());
		}
		System.out.println(list);

	}
}
