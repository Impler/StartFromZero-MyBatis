package com.study.mybatis.test.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.mybatis.spring.dao.UserDao;


public class TestSqlSessionTemplate {

	private ClassPathXmlApplicationContext context;
	
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext("spring/sqlSessionTemplate.xml");
	}
	
	@Test
	public void testUser() throws Exception {
		UserDao userDao = (UserDao) context.getBean("userDaoImpl");
		System.out.println(userDao.selectOneByKey(1));
		System.out.println(userDao.selectOneByKey(1));
	}

}
