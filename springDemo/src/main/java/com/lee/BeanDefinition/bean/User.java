package com.lee.BeanDefinition.bean;

import java.util.Date;

public class User {
	private int userId;
	private String name;
	private int sex;
	private int age;
	private Date birthday;
	private long phone;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", name='" + name + '\'' +
				", sex=" + sex +
				", age=" + age +
				", birthday=" + birthday +
				", phone=" + phone +
				'}';
	}

	public void sayHel() {
		System.out.println(userId + "：" + name + ",sayHello!");
	}


}
