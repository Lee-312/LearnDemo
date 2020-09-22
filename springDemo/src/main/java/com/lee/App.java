package com.lee;

import com.lee.BeanDefinition.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
@SuppressWarnings("ALL")
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) applicationContext.getBean("user");
		user.sayHel();
		User user2 = (User) applicationContext.getBean("user");
		user2.sayHel();
	}
}
