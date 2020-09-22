package com.lee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {
	public static void main(String[] args) {
		//给定二叉树 [3,9,20,null,null,15,7],
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(9);
		TreeNode c = new TreeNode(20);
		TreeNode d = new TreeNode(15);
		TreeNode e = new TreeNode(7);
		a.left = b;
		a.right = c;
		c.left = d;
		c.right = e;
		List<List<Integer>> lists = levelOrderBottom1(a);
		for (List<Integer> list : lists) {
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> lists = new LinkedList<>();//汇总list
		if (root == null) {
			return lists;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> tmp = new LinkedList<>();//存放一层的节点值
			int size = queue.size();//获取当前对列长度
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();//获取队首node
				tmp.add(node.val);
				// 判断当前node的左右节点，如果存在则添加到队列尾，在下一次便利时使用
				TreeNode left = node.left;
				TreeNode right = node.right;
				if (left != null) {
					queue.add(left);
				}
				if (right != null) {
					queue.add(right);
				}
			}
			lists.add(0,tmp);
		}
		return lists;
	}


	public static List<List<Integer>> levelOrderBottom1(TreeNode root) {
		List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
		if (root == null) {
			return levelOrder;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				TreeNode left = node.left;
				TreeNode right = node.right;
				if (left != null) {
					queue.offer(left);
				}
				if (right != null) {
					queue.offer(right);
				}
			}
			levelOrder.add(0, level);
		}
		return levelOrder;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
 