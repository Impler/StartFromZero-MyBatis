package com.study.mybatis.spring.mapperFactoryBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.study.mybatis.spring.sqlSessionTemplate.UserDao;

public class UserDaoImpl {
	
	@Autowired
	private UserDao userDao;
	
}
