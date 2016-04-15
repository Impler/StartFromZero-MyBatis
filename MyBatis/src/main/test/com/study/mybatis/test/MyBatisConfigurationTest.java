package com.study.mybatis.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class MyBatisConfigurationTest {

	/**
	 * SqlSessionFactoryBuilder.builder方法，传递mybatis配置流
	 */
	@Test
	public void testSqlSessionBuilderInputStream(){
		try {
			InputStream input = null;
			input = Resources.getResourceAsStream("mybatis.xml");
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			//创建完SqlSessionFactory实例，mybatis立即关闭input流
			SqlSessionFactory factory = builder.build(input);
			System.out.println(factory.getConfiguration().getEnvironment().getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * SqlSessionFactoryBuilder.builder重载方法，传递指定的environment id
	 */
	@Test
	public void testSqlSessionBuilderInputStreamAndEnv(){
		try {
			InputStream input = null;
			input = Resources.getResourceAsStream("mybatis.xml");
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(input, "test");
			System.out.print("env id:" + factory.getConfiguration().getEnvironment().getId());
			//抛异常，创建connection时候出错，由于db.properties中test环境密码不对
			System.out.println(" connection isclosed: " + factory.openSession().getConnection().isClosed());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * SqlSessionFactoryBuilder.builder重载方法，传递指定的environment id和自定义property
	 * 由此验证Mybatis处理properties文件顺序
	 * 1 加载mybatis配置文件中的properties标签体内的配置
	 * 2 加载mybatis配置文件中的perperties标签resource/url属性引用的外部properties，覆盖第一步的相同内容
	 * 3 加载SqlSessionBuilder.builder方法传入的properties对象，覆盖上面的相同内容 
	 */
	@Test
	public void testSqlSessionBuilderInputStreamAndEnvAndPros(){
		try {
			InputStream input = null;
			input = Resources.getResourceAsStream("mybatis.xml");
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			Properties pro = new Properties();
			pro.setProperty("test.jdbc.password", "root");
			SqlSessionFactory factory = builder.build(input, "test", pro);
			System.out.print("env id:" + factory.getConfiguration().getEnvironment().getId());
			//正常运行，自定义properties会覆盖配置中的变量
			System.out.println(" connection isclosed: " + factory.openSession().getConnection().isClosed());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private SqlSessionFactory factory;

	@Before
	public void before() {
		InputStream input = null;
		try {
			input = Resources.getResourceAsStream("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testConnection() {
		SqlSession session = factory.openSession();
		try {
			System.out.println("数据库连接正常：" + !session.getConnection().isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
