package com.study.mybatis.test;

import java.util.List;

import org.junit.Test;

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

}
