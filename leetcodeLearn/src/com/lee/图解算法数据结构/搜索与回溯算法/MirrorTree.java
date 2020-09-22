package com.lee.图解算法数据结构.搜索与回溯算法;

public class MirrorTree {
	public static void main(String[] args) {
		//[4,2,7,1,3,6,9]
		TreeNode a = new TreeNode(4);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(7);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(3);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(9);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		mirrorTree(a);
	}

	public static TreeNode mirrorTree(TreeNode root) {
		if (root != null) {
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;
			mirrorTree(root.left);
			mirrorTree(root.right);
		}
		return root;
	}

}
