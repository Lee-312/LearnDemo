package com.lee;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

	/**
	 * 输入：
	 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
	 * [[],[2],[],[3],[]]
	 * 输出：[null,null,2.00000,null,2.50000]
	 */
	public static void main(String[] args) {

	}

	private Queue<Integer> left, right;

	public MedianFinder() {
		left = new PriorityQueue();
		right = new PriorityQueue(Collections.reverseOrder());
	}

	public void addNum(int num) {
		if (left.size() != right.size()) {
			left.add(num);
			right.add(left.poll());
		} else {
			right.add(num);
			left.add(right.poll());
		}
	}

	public double findMedian() {
		return left.size() != right.size() ? left.peek() : (left.peek() + right.peek()) / 2.0;
	}
}
