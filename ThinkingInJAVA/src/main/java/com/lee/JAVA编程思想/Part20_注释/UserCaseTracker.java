package com.lee.JAVA编程思想.Part20_注释;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserCaseTracker {

	public static void trackUserCases(List<Integer> useCases, Class<?> c1) {
		for (Method method : c1.getDeclaredMethods()) {
			UserCase userCase = method.getAnnotation(UserCase.class);
			if (useCases != null) {
				System.out.println("Found Use Case : " + userCase.id() + " " + userCase.description());
				useCases.remove(new Integer(userCase.id()));
			}
		}
		for (Integer useCase : useCases) {
			System.out.println("Warning: Missing use case- " + useCase);
		}
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list,47,48,49,50);
		trackUserCases(list,PasswordUtils.class);
	}
}
