package com.lee.AnnotationBased;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("annotationContext.xml");

		Person p = context.getBean("person", Person.class);
		System.out.println(p);
	}
}
