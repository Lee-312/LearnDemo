package com.lee.图解算法数据结构;

import java.util.Arrays;

public class GetWinner {


	public static void main(String[] args) {
		System.out.println(getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
		/*int[] s = new int[]{2, 1, 3, 5, 4, 6, 7};
		int tmp = s[0];
		s[0] = s[1];
		System.arraycopy(s, // 原数组
				2, // 元素组起始位置
				s,  //目标数组
				1, // 目标数组起始位置
				s.length - 2 // 拷贝长度
		);
		s[s.length - 1] = tmp;
		System.out.println(Arrays.toString(s));*/
	}

	public static int getWinner(int[] arr, int k) {
		int time = 0;
		while (time != k) {
			if (arr[0] >= arr[1]) {
				int tmp = arr[1];
				System.arraycopy(arr, // 原数组
						2, // 元素组起始位置
						arr,  //目标数组
						1, // 目标数组起始位置
						arr.length - 2 // 拷贝长度
				);
				arr[arr.length - 1] = tmp;
				time++;
			} else {
				time = 1;
				int tmp = arr[0];
				arr[0] = arr[1];
				System.arraycopy(arr, 2, arr, 1, arr.length - 2);
				arr[arr.length - 1] = tmp;
			}
		}
		return arr[0];
	}
}
