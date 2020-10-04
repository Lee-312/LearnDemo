package com.lee;

public class MinimumOperations {
	public static void main(String[] args) {

	}

	public static int minimumOperations(String leaves) {
		//ryr结构

		//全是r return 1
		//全是y return 2
		//r开头，r结尾，return 第一次出现y的位置到最后第二位间出现的r的个数
		//r开头，y结尾，return 第一次出现y的位置（不能是最后一位）到最后第二位间出现的r的个数 + 1

		//y开头，r结尾，return 第一次出现y的位置到最后第二位间出现的r的个数
		//r开头，y结尾，return 第一次出现y的位置（不能是最后一位）到最后第二位间出现的r的个数 + 1

		return 0;
	}

}
