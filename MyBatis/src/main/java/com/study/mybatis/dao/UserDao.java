package com.study.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.study.mybatis.domain.User;

public interface UserDao extends BaseDao<User, Integer>{
	//only for study test case below
	public List<User> selectByCondition1(User entity);
	public List<User> selectByCondition2(User entity);
	public List<User> selectByCondition3(User entity);
	
	public int update1(User entity);
	
	public List<User> selectByIds(Integer[] ids);
	public List<User> selectByIds1(List<Integer> ids);
	
	public List<User> selectByRoleAndStatus(List<Integer> roleIds, List<Integer> statusIds);
	public List<User> selectByRoleAndStatus1(@Param("roleIds")List<Integer> roleIds, @Param("statusIds")List<Integer> statusIds);
	public List<User> selectByRoleAndStatus1(Map<String, List<Integer>> roleAndStatus);
}
