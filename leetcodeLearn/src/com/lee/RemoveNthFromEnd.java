package com.lee;

import java.util.Deque;
import java.util.LinkedList;


public class RemoveNthFromEnd {
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		removeNthFromEnd(a, 2);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		Deque<ListNode> deque = new LinkedList();
		ListNode root = head;
		int count = 0;
		while (root != null) {
			// 保证deque长度为n+1
			if (deque.size() < (n + 1)) {
				deque.offer(root);
			} else {
				deque.poll();
				deque.offer(root);
			}
			count++;
			root = root.next;
		}

		// 删除的是头
		if (count == n) {
			return head.next;
		}
		// 删除的是中间
		ListNode n1 = deque.poll();
		ListNode n2 = deque.poll();
		if (n2 != null) {
			n1.next = n2.next;
		} else {
			n1 = null;
			n1.next = null;
		}

		return head;
	}

	public static ListNode removeNthFromEnd1(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		// Advances first pointer so that the gap between first and second is n nodes apart
		for (int i = 1; i <= n + 1; i++) {
			first = first.next;
		}
		// Move first to the end, maintaining the gap
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}


}
