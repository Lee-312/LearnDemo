package com.lee.My20200518;

public class test1 {
	public static void main(String[] args) {
		//
		String s1 = ArrayUtil.getMiddle("abc", "def", "ghi");
		Integer i1 = ArrayUtil.getMiddle(1, 2, 3);
		String s2 = ArrayUtil.getMiddle("abc", "def", null);
		//Integer i2 =  ArrayUtil.getMiddle(1,2.5f,3L);//error
		System.out.println(s1 + s2);
	}
}

class ArrayUtil {
	public static <T> T getMiddle(T... a) {
		return a[a.length / 2];
	}
}
