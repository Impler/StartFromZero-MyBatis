package com.study.mybatis.dao.impl;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<User> selectByIds(Integer[] ids) {
		return super.getDao().selectByIds(ids);
	}

	@Override
	public List<User> selectByIds1(List<Integer> ids) {
		return super.getDao().selectByIds1(ids);
	}

	@Override
	public List<User> selectByRoleAndStatus(List<Integer> roleIds, List<Integer> statusIds) {
		return super.getDao().selectByRoleAndStatus(roleIds, statusIds);
	}

	@Override
	public List<User> selectByRoleAndStatus1(List<Integer> roleIds, List<Integer> statusIds) {
		return super.getDao().selectByRoleAndStatus1(roleIds, statusIds);
	}

	@Override
	public List<User> selectByRoleAndStatus1(Map<String, List<Integer>> roleAndStatus) {
		return super.getDao().selectByRoleAndStatus1(roleAndStatus);
	}

	@Override
	public List<User> selectByStatusAndRole(int status, int role) {
		return super.getDao().selectByStatusAndRole(status, role);
	}

	@Override
	public List<User> selectByStatusAndRole1(Map<String, Integer> params) {
		return super.getDao().selectByStatusAndRole1(params);
	}

	@Override
	public List<User> selectByStatusAndRole1(int role, int status) {
		return super.getDao().selectByStatusAndRole1(role, status);
	}

	@Override
	public Map<String, Object> simpleSelectMap() {
		return super.getDao().simpleSelectMap();
	}

	@Override
	public User simpleSelectBean() {
		return super.getDao().simpleSelectBean();
	}

	@Override
	public User simpleSelectResultMapConstructor() {
		return super.getDao().simpleSelectResultMapConstructor();
	}

}
