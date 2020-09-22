package com.lee.BeanDefinition.dao.impl;

import com.lee.BeanDefinition.dao.UserDao;

public class UserDaoImpl implements UserDao {
	@Override
	public void getUser() {
		System.out.println("获取普通用户测试");
	}
}
