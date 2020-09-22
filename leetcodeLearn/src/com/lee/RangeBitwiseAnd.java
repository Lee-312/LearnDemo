package com.lee;

import java.util.ArrayList;
import java.util.List;

public class RangeBitwiseAnd {


	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5, 9));
	}

	public static int rangeBitwiseAnd(int m, int n) {
		// &运算，有零出零，全一出一
		// 右移直到两数相等，num记录右移次数
		// 将m左移对应位则获取到m，n两数位值都为1的位数的十进制值
		int num = 0;
		while(m!=n){
			m = m>>1;
			n = n>>1;
			num++;
		}
		return m<<num;
	}

}
