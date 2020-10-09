package com.lee.JAVA编程思想.Part11_持有对象;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class LinkedListFeatures {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>(Arrays.asList("Rat", "Manx", "Cymric", "Mutt", "Pug"));
		System.out.println(list);

		System.out.println("list.getFirst()" + list.getFirst());
		System.out.println("list.element()" + list.element());
		System.out.println("list.peek()" + list.peek());
		System.out.println("list.remove()" + list.remove());
		System.out.println("list.removeFirst()" + list.removeFirst());

		System.out.println("list.poll()" + list.poll());
		System.out.println(list);
		list.addFirst("Rat");
		System.out.println("After addFirst()" + list);
		list.offer(new Random().nextInt() + "");
		System.out.println("After offer()" + list);
		list.add(new Random().nextInt() + "");
		System.out.println("After add()" + list);

		list.addLast(new Random().nextInt() + "");
		System.out.println("After addLast()" + list);
		System.out.println("list.removeLast()" + list.removeLast());


	}
}
