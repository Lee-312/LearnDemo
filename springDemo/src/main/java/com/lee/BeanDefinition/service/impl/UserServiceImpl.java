package com.lee.BeanDefinition.service.impl;

import com.lee.BeanDefinition.dao.UserDao;
import com.lee.BeanDefinition.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void getUser() {
		userDao.getUser();
	}
}
