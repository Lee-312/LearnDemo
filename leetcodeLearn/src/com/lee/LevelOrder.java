package com.lee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelOrder {
	public static void main(String[] args) {
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(9);
		TreeNode c = new TreeNode(20);
		TreeNode d = new TreeNode(15);
		TreeNode e = new TreeNode(7);
		a.left = b;
		a.right = c;
		c.left = d;
		c.right = e;
		System.out.println("层序遍历");
		for (List<Integer> list : levelOrder(a)) {
			for (Integer integer : list) {
				System.out.print(integer + "  ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("递归前序遍历");
		PreOrderPrintLevels(a);
	}


	public static void PreOrderPrintLevels(TreeNode root) {
		if (root != null) {
			System.out.println(root.val);
			PreOrderPrintLevels(root.left);
			PreOrderPrintLevels(root.right);
		}

	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> outList = new LinkedList<>();
		if (root != null) {
			queue.add(root);
		}
		while (!queue.isEmpty()) {
			List<Integer> tmp = new LinkedList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode pop = queue.poll();
				if (pop.left != null) {
					queue.add(pop.left);
				}
				if (pop.right != null) {
					queue.add(pop.right);
				}
				tmp.add(pop.val);
			}
			outList.add(tmp);
		}
		return outList;
	}

}
