package com.study.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.study.mybatis.dao.SqlSessionUtil;
import com.study.mybatis.dao.UserDao;
import com.study.mybatis.domain.User;

public class UserDaoImpl implements UserDao {

	@Override
	public int insert(User entity) {
		return 0;
	}

	@Override
	public int update(User entity) {
		return 0;
	}

	@Override
	public int delete(User entity) {
		return 0;
	}

	@Override
	public List<User> select() {
		SqlSession session =  SqlSessionUtil.getSession();
		UserDao dao = session.getMapper(UserDao.class);
		return dao.select();
	}

}
