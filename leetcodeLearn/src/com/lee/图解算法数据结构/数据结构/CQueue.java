package com.lee.图解算法数据结构.数据结构;

import java.util.Stack;

class CQueue {

	public static void main(String[] args) {
		/**
		 * "CQueue","appendTail","deleteHead","deleteHead"]
		 * [[],[3],[],[]]
		 */
		CQueue queue = new CQueue();
		queue.appendTail(3);
		queue.deleteHead();
		queue.deleteHead();
	}
	public String replaceSpace(String s) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if(str.charAt(i) == ' '){
				str.append('%').append('2').append('0');
			}else {
				str.append(s.charAt(i));
			}
		}
		return str.toString();
	}
	Stack<Integer> appStack, delStack;

	public CQueue() {
		appStack = new Stack();
		delStack = new Stack();
	}

	public void appendTail(int value) {
		appStack.push(value);
	}

	public int deleteHead() {
		int r = -1;
		if (!delStack.isEmpty()) {
			r = delStack.pop();

		} else {
			if (!appStack.isEmpty()) {
				while (!appStack.isEmpty()) {
					delStack.push(appStack.pop());
				}
				r = delStack.pop();
			}
		}
		return r;
	}
}