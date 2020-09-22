package com.lee.图解算法数据结构.数据结构;

import java.util.Arrays;
import java.util.Stack;

public class ReversePrint {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		System.out.println(Arrays.toString(reversePrint(n1)));
	}

	public static int[] reversePrint(ListNode head) {
		Stack<ListNode> stack = new Stack();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		int[] newHead = new int[stack.size()];
		int index = 0;
		while (!stack.isEmpty()) {
			newHead[index++] = stack.pop().val;
		}
		return newHead;
	}

}