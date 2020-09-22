package com.lee.BeanDefinition.dao.impl;

import com.lee.BeanDefinition.dao.UserDao;

public class OracleUserDaoImpl implements UserDao {
	@Override
	public void getUser() {
		System.out.println("获取Oracle用户测试");
	}
}
