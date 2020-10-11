package com.lee.JAVA编程思想.Part14_类型信息;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
	private static List<Class<? extends Pet>> types = new ArrayList<>();
	private static String[] typeNames = {
			"com.lee.JAVA编程思想.Part14_类型信息.Mutt",
			"com.lee.JAVA编程思想.Part14_类型信息.Pug",
			"com.lee.JAVA编程思想.Part14_类型信息.EgyptianMau",
			"com.lee.JAVA编程思想.Part14_类型信息.Manx",
			"com.lee.JAVA编程思想.Part14_类型信息.Cymic",
			"com.lee.JAVA编程思想.Part14_类型信息.Rat",
			"com.lee.JAVA编程思想.Part14_类型信息.Mouse",
			"com.lee.JAVA编程思想.Part14_类型信息.Hamster",
	};

	private static void loader() {
		try {
			for (String name : typeNames) {
				types.add((Class<? extends Pet>) Class.forName(name));
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	static {
		loader();
	}

	@Override
	public List<Class<? extends Pet>> types() {
		return types;
	}
}
