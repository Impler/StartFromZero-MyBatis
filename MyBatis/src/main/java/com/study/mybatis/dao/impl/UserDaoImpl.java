package com.study.mybatis.dao.impl;



import java.util.List;

import com.study.mybatis.dao.AbstractDao;
import com.study.mybatis.dao.UserDao;
import com.study.mybatis.domain.User;

public class UserDaoImpl extends AbstractDao<UserDao, User, Integer> implements UserDao {

	@Override
	public List<User> selectByCondition1(User entity) {
		return super.getDao().selectByCondition1(entity);
	}
	
	@Override
	public List<User> selectByCondition2(User entity) {
		return super.getDao().selectByCondition2(entity);
	}
	
	@Override
	public List<User> selectByCondition3(User entity) {
		return super.getDao().selectByCondition3(entity);
	}

	@Override
	public int update1(User entity) {
		return super.getDao().update1(entity);
	}

}
