package com.study.mybatis.test.spring;

import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIntegrateWithSpring {

	private ClassPathXmlApplicationContext context;
	private SqlSessionTemplate template;
	
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		template = (SqlSessionTemplate) context.getBean("sqlSession");
	}
	
	@Test
	public void test() throws Exception {
		System.out.println(template.getConnection().isClosed());
	}

}
