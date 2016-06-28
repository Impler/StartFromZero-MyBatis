package com.study.mybatis.test.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class TestProperties {

	InputStream input = null;
	
	@Before
	public void before() throws IOException{
		input = Resources.getResourceAsStream("core/mybatis.xml");
	}
	/**	
	 * test.jdbc.password 以db.properties中的为准
	 * <properties resource="db.properties">
	 * 	<property name="test.jdbc.password" value="root1"/>
	 * </properties>
	*/
	@Test
	public void overrideByResource() {
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
		Properties pros = factory.getConfiguration().getVariables();
		
		print(pros);
	}
	
	/**	
	 * test.jdbc.password 以入参为准
	 * <properties resource="db.properties">
	 * 	<property name="test.jdbc.password" value="root1"/>
	 * </properties>
	*/
	@Test
	public void overrideByParameter() {
		Properties pro = new Properties();
		pro.put("test.jdbc.password", "parameter password");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input, pro);
		Properties pros = factory.getConfiguration().getVariables();
		
		print(pros);
		
	}
	
	private void print(Properties pro){
		Enumeration<Object> keys = pro.keys();
		while(keys.hasMoreElements()){
			String key = (String) keys.nextElement();
			System.out.println(key + " : " + pro.get(key));
		}
	}

}
