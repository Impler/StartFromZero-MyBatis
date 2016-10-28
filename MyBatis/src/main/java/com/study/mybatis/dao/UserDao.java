package com.study.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.study.mybatis.commenum.UserRoleEnum;
import com.study.mybatis.domain.User;

public interface UserDao extends BaseDao<User, Integer>{
	// test simple select 
	// return map
	public Map<String, Object> simpleSelectMap();
	// return bean
	public User simpleSelectBean();
	
	// test resultmap constructor
	public User simpleSelectResultMapConstructor();
	
	// test multi parameters
	public List<User> selectByStatusAndRole(int status, int role);
	public List<User> selectByStatusAndRole1(Map<String, Integer> params);
	public List<User> selectByStatusAndRole1(@Param("_role")int role, @Param("_status")int status);
	
	public List<UserRoleEnum> discriminatorUserRole();
	//only for study dynamic sql test case below
	//test choose when otherwise
	public List<User> selectByCondition1(User entity);
	//test where
	public List<User> selectByCondition2(User entity);
	//test trim
	public List<User> selectByCondition3(User entity);
	
	//test set s
	public int update1(User entity);
	//test set e
	
	//test foreach s
	public List<User> selectByIds(Integer[] ids);
	public List<User> selectByIds1(List<Integer> ids);
	
	public List<User> selectByRoleAndStatus(List<Integer> roleIds, List<Integer> statusIds);
	public List<User> selectByRoleAndStatus1(@Param("roleIds")List<Integer> roleIds, @Param("statusIds")List<Integer> statusIds);
	public List<User> selectByRoleAndStatus1(Map<String, List<Integer>> roleAndStatus);
	//test foreach e
	
	// 单个基本数据类型参数
	User selectById(int id);
	// 多个基本类型参数见 selectByStatusAndRole
	
	//在SqlSession API的方法中传入基本类型参数，如果Dao层方法参数为最终传入的参数，那么情况同selectById，否则无法辨别参数
	User testFoo(int foo, int bar);
	
}
