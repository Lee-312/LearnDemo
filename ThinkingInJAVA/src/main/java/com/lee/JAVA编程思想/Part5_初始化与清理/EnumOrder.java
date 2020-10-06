package com.lee.JAVA编程思想.Part5_初始化与清理;

public class EnumOrder {
	public static void main(String[] args) {
		for (Spiciness value : Spiciness.values()) {
			System.out.println(value + ",ordinal" + value.ordinal());
		}
	}
}

enum Spiciness {
	NOT, MILD, MEDIUM, HOT, FLAMING
}
