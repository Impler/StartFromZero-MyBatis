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
	
	@Test
	public void testSelect(){
		List<User> users = userDao.select();
		for(User u : users){
			System.out.println(u);
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
		System.out.println(u);
		
	}
	

}
