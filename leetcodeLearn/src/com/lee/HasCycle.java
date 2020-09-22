package com.lee;

public class HasCycle {

	public static void main(String[] args) {
		ListNodeA a = new ListNodeA(3);
		ListNodeA b = new ListNodeA(2);
		ListNodeA c = new ListNodeA(0);
		ListNodeA d = new ListNodeA(-4);
		a.next = b;
		b.next = c;
		c.next = d;
		System.out.println(hasCycle(a));
	}

	public static boolean hasCycle(ListNodeA head) {
		int count = 0;
		ListNodeA fast = head;
		ListNodeA slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}
		if (fast != null && fast.next != null) {
			return false;
		}
		return true;
	}
}


class ListNodeA {
	int val;
	ListNodeA next;

	ListNodeA(int x) {
		val = x;
		next = null;
	}
}
