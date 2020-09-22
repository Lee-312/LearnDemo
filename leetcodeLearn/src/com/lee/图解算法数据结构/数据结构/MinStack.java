package com.lee.图解算法数据结构.数据结构;

import java.util.Stack;

class MinStack {

	private Stack<Integer> stack, minStack;

	/**
	 * initialize your data structure here.
	 */
	public MinStack() {
		stack = new Stack();// 对外显示的stack
		minStack = new Stack();// 维护当前最小数
	}

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || minStack.peek() >= x) {
			minStack.push(x);
		}
	}

	public void pop() {
		int tmp = stack.pop();
		if(tmp == minStack.peek()){
			minStack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int min() {
		return minStack.peek();
	}
}