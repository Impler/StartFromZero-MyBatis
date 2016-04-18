package com.study.mybatis.dao;

import java.util.List;

import com.study.mybatis.domain.User;

public interface UserDao extends BaseDao<User, Integer>{
	//only for study test case below
	public List<User> selectByCondition1(User entity);
	public List<User> selectByCondition2(User entity);
	public List<User> selectByCondition3(User entity);
	public int update1(User entity);
}
