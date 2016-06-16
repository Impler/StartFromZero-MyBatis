package com.study.mybatis.test.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.mybatis.spring.mapperFactoryBean.UserService;

public class TestMapperBeanFactory {

	private ClassPathXmlApplicationContext context;
	
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext("spring/mapperFactoryBean.xml");
	}
	
	@Test
	public void testUser() throws Exception {
		UserService service = (UserService) context.getBean("userService");
		service.getUserDao().selectOneByKey(1);
		service.getUserDao().selectOneByKey(1);
	}

}
