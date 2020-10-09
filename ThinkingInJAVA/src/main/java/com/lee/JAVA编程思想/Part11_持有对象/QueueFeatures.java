package com.lee.JAVA编程思想.Part11_持有对象;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class QueueFeatures {
	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList<>();
		Random random = new Random(47);
		for (int i = 0; i < 10; i++) {
			queue.add(random.nextInt(i + 10));
		}
		printQ(queue);
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		for (int i = 0; i < 10; i++) {
			priorityQueue.add(random.nextInt(i + 10));
		}
		PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(priorityQueue.size(), Collections.reverseOrder());
		priorityQueue2.addAll(priorityQueue);
		printQ(priorityQueue);
		printQ(priorityQueue2);

	}

	public static void printQ(Queue queue) {
		while (!queue.isEmpty()) {
			System.out.print(queue.remove() + " ");
		}
		System.out.println();
	}
}
