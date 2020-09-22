package com.lee.图解算法数据结构.搜索与回溯算法;

public class IsSymmetric {

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(4);
		TreeNode f = new TreeNode(4);
		TreeNode g = new TreeNode(3);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		//c.left = f;
		c.right = g;
		System.out.println(isSymmetric(a));
	}

	public static boolean isSymmetric(TreeNode root) {
		return root == null || isEqual(root.left, root.right);
	}

	public static boolean isEqual(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		}
		if (a == null || b == null || a.val != b.val) {
			return false;
		}
		return isEqual(a.left, b.right) && isEqual(a.right, b.left);
	}

}
