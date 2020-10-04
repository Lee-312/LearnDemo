package com.lee;

public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(5);
		ListNode e = new ListNode(6);
		ListNode f = new ListNode(4);
		a.next = b;
		b.next = c;
		d.next = e;
		e.next = f;
		addTwoNumbers(a, d);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int headVal = l1.val + l2.val;
		boolean flag = false;
		ListNode head = null;
		if (headVal >= 10) {
			flag = true;
			head = new ListNode(headVal % 10);
		} else {
			head = new ListNode(headVal);
		}
		l1 = l1.next;
		l2 = l2.next;
		ListNode tmp = head;

		while (l1 != null && l2 != null) {
			int tmpVal = 0;
			if (flag) {
				tmpVal = l1.val + l2.val + 1;
			} else {
				tmpVal = l1.val + l2.val;
			}
			if (tmpVal >= 10) {
				tmpVal = tmpVal % 10;
				flag = true;
			} else {
				flag = false;
			}
			tmp.next = new ListNode(tmpVal);
			tmp = tmp.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			int tmpVal = 0;
			if (flag) {
				tmpVal = l1.val + 1;
				if (tmpVal >= 10) {
					flag = true;
				} else {
					flag = false;
				}
			} else {
				tmpVal = l1.val;
				flag = false;
			}
			tmp.next = new ListNode(tmpVal);
			tmp = tmp.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			int tmpVal = 0;
			if (flag) {
				tmpVal = l2.val + 1;
				if (tmpVal >= 10) {
					flag = true;
				} else {
					flag = false;
				}
			} else {
				tmpVal = l2.val;
				flag = false;
			}
			tmp.next = new ListNode(tmpVal);
			tmp = tmp.next;
			l2 = l2.next;
		}
		if(flag){
			tmp.next = new ListNode(1);
		}

		return head;
	}
}
