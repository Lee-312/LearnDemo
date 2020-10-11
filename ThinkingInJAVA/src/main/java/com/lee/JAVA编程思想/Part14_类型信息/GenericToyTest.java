package com.lee.JAVA编程思想.Part14_类型信息;

public class GenericToyTest {
	public static void main(String[] args) throws Exception {
		Class<FancyToy> fancyToy = FancyToy.class;
		FancyToy toy = fancyToy.newInstance();
		Class<? super FancyToy> up = fancyToy.getSuperclass();
//		Class<Toy> toyRef = fancyToy.getSuperclass();
		Object object = up.newInstance();


	}
}
