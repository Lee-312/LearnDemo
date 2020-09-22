package com.lee.图解算法数据结构.搜索与回溯算法;

public class IsSubStructure {
	public static void main(String[] args) {
//A = [3,4,5,1,2], B = [4,1]
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(4);
		TreeNode c = new TreeNode(5);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(2);

		TreeNode a1 = new TreeNode(4);
		TreeNode a2 = new TreeNode(1);


		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;

		a1.left = a2;

		System.out.println(isSubStructure(a, a1));
	}


	public static boolean isSubStructure(TreeNode A, TreeNode B) {
		return (A != null && B != null) && (isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
	}

	static boolean isSub(TreeNode A, TreeNode B) {
		if (B == null) {
			return true;
		}
		if (A == null || A.val != B.val) {
			return false;
		}
		return isSub(A.left, B.left) && isSub(A.right, B.right);
	}
}
