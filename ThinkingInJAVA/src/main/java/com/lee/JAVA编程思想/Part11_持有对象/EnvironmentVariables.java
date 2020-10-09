package com.lee.JAVA编程思想.Part11_持有对象;

import java.util.Map;

public class EnvironmentVariables {
	public static void main(String[] args) {
		for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
			System.out.println(entry.getKey() + "，" + entry.getValue());
		}
	}
}
