package com.study.mybatis.test;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.study.mybatis.commenum.UserActiveStatusEnum;
import com.study.mybatis.commenum.UserRoleEnum;
import com.study.mybatis.commenum.util.EnumUtil;
import com.study.mybatis.dao.UserDao;
import com.study.mybatis.dao.impl.UserDaoImpl;
import com.study.mybatis.domain.User;

public class TestMyBatisCRUD {

	private UserDao userDao = new UserDaoImpl();
	
	//test CRUD start
	@Test
	public void testSelect(){
		List<User> users = userDao.select();
		for(User u : users){
			System.out.println("testSelect: " + u);
		}
	}
	
	@Test
	public void testInsert(){
		User u = new User();
		u.setUsername("KOBE" + (int)(Math.random() * 10));
		u.setCreateTime(new Date());
		u.setEmail("34444444444444@qq.com");
		u.setTelNumber("121212121");
		u.setPassword("QWEasd123");
		UserActiveStatusEnum active = EnumUtil.getEnumConstant(UserActiveStatusEnum.class, new Random().nextInt(2));
		u.setActive(active);
		UserRoleEnum role = EnumUtil.getEnumConstant(UserRoleEnum.class, new Random().nextInt(2) + 1);
		u.setRole(role);
		userDao.insert(u);
		System.out.println("testInsert: " + u);
	}
	
	
	@Test
	public void testSelectOneByKey(){
		User u = userDao.selectOneByKey(1);
		System.out.println("testSelectOneByKey: " + u);
	}
	
	@Test
	public void testUpdate(){
		User u = userDao.selectOneByKey(1);
		System.out.println("testUpdate before: " + u);
		u.setEmail("update" + u.getEmail());
		userDao.update(u);
		System.out.println("testUpdate after: " + u);
	}
	
	@Test
	public void testDelete(){
		List<User> users = userDao.select();
		for(User u : users){
			System.out.println("testDelete before: " + u);
		}
		userDao.delete(users.get(users.size() - 1).getId());
		
		users = userDao.select();
		for(User u : users){
			System.out.println("testDelete after: " + u);
		}
	}
	//test CRUD end 
	
	//test dynamic sql start
	
	/**
	 * test <if />
	 */
	@Test
	public void testSelectByCondition(){
		User user = new User();
		List<User> users = userDao.selectByCondition(user);
		System.out.println("select by condition: " + user);
		for(User u : users){
			System.out.println(u);
		}
		user.setEmail("3");
		users = userDao.selectByCondition(user);
		System.out.println("select by condition: " + user);
		for(User u : users){
			System.out.println(u);
		}
		user.setRole(UserRoleEnum.ADMIN);
		users = userDao.selectByCondition(user);
		System.out.println("select by condition: " + user);
		for(User u : users){
			System.out.println(u);
		}
	}
	
	/**
	 * test <choose/> <when /> <otherwise />
	 */
	@Test
	public void testSelectByCondition1(){
		User user = new User();
		List<User> users = userDao.selectByCondition1(user);
		System.out.println("select by condition1: " + user);
		for(User u : users){
			System.out.println(u);
		}
		user.setEmail("3");
		users = userDao.selectByCondition1(user);
		System.out.println("select by condition1: " + user);
		for(User u : users){
			System.out.println(u);
		}
		user.setEmail(null);;
		user.setRole(UserRoleEnum.ADMIN);
		users = userDao.selectByCondition1(user);
		System.out.println("select by condition1: " + user);
		for(User u : users){
			System.out.println(u);
		}
	}
	/**
	 * test <where />
	 */
	@Test
	public void testSelectByCondition2(){
		User user = new User();
		List<User> users = userDao.selectByCondition2(user);
		System.out.println("select by condition2: " + user);
		for(User u : users){
			System.out.println(u);
		}
		user.setEmail("3");
		users = userDao.selectByCondition2(user);
		System.out.println("select by condition2: " + user);
		for(User u : users){
			System.out.println(u);
		}
		user.setRole(UserRoleEnum.ADMIN);
		users = userDao.selectByCondition2(user);
		System.out.println("select by condition2: " + user);
		for(User u : users){
			System.out.println(u);
		}
	}
	
	/**
	 * test <trim />
	 */
	@Test
	public void testSelectByCondition3(){
		User user = new User();
		List<User> users = userDao.selectByCondition3(user);
		System.out.println("select by condition3: " + user);
		for(User u : users){
			System.out.println(u);
		}
		user.setEmail("3");
		users = userDao.selectByCondition3(user);
		System.out.println("select by condition3: " + user);
		for(User u : users){
			System.out.println(u);
		}
		user.setRole(UserRoleEnum.ADMIN);
		users = userDao.selectByCondition3(user);
		System.out.println("select by condition3: " + user);
		for(User u : users){
			System.out.println(u);
		}
	}
	
	@Test
	public void testUpdate1(){
		User user = new User();
		user.setId(1);
		User u = userDao.selectOneByKey(user.getId());
		user.setEmail("update1" + u.getEmail());
		System.out.println("update1 before:" + u);
		userDao.update1(user);
		System.out.println("update:" + user);
		u = userDao.selectOneByKey(user.getId());
		System.out.println("update1 after:" + u);
		user.setRole(UserRoleEnum.ADMIN);
		userDao.update1(user);
		System.out.println("update:" + user);
		System.out.println("update1 after:" + u);
	}
	//test dynamic sql end

}
