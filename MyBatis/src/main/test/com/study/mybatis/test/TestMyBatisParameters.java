package com.study.mybatis.test;

import java.util.List;

import org.junit.Test;

import com.study.mybatis.dao.UserDao;
import com.study.mybatis.dao.impl.UserDaoImpl;
import com.study.mybatis.domain.User;

public class TestMyBatisParameters {
	
	private UserDao userDao = new UserDaoImpl();
	@Test
	public void testBasicDataTypeWithOneParam() {
		int i = 1;
		User u = userDao.selectById(i);
		System.out.println(u);
	}
	
	@Test
	public void testBasicDataTypeWithMultiParams() {
		int status = 1;
		int role = 1;
		List<User> us = userDao.selectByStatusAndRole(status, role);
		System.out.println(us);
	}
	
	@Test
	public void testBasicDataTypeWithMultiParamsByAnno() {
		int status = 1;
		int role = 1;
		List<User> us = userDao.selectByStatusAndRole1(role, status);
		System.out.println(us);
	}
	@Test
	public void testBasicDataTypeWithOneParamOfAPI() {
		int foo = 2;
		int bar = 1;
		User u = userDao.testFoo(foo, bar);
		System.out.println(u);
	}
	
	

}
