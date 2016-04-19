package com.study.mybatis.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	/**
	 * test <set />
	 */
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
		u = userDao.selectOneByKey(user.getId());
		System.out.println("update1 after:" + u);
	}
	
	/**
	 * <foreach /> array
	 */
	@Test
	public void testSelectByIds() {
		Integer[] ids = {};
		List<User> users = userDao.selectByIds(ids);
		System.out.println("SelectByIds: " + ids);
		for(User u : users){
			System.out.println(u);
		}
		
		ids = new Integer[]{1, 3, 23};
		users = userDao.selectByIds(ids);
		System.out.println("SelectByIds: " + ids);
		for(User u : users){
			System.out.println(u);
		}
	}
	
	/**
	 * <foreach /> list
	 */
	@Test
	public void testSelectByIds1() {
		List<Integer> ids = null;
		List<User> users = userDao.selectByIds1(ids);
		System.out.println("SelectByIds1: " + ids);
		for(User u : users){
			System.out.println(u);
		}
		
		ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(3);
		ids.add(23);
		users = userDao.selectByIds1(ids);
		System.out.println("SelectByIds1: " + ids);
		for(User u : users){
			System.out.println(u);
		}
	}
	
	/**
	 * <foreach /> param0,1...
	 */
	@Test
	public void testSelectByRoleAndStatus() {
		List<Integer> roleIds = new ArrayList<Integer>();
		List<Integer> activeIds = new ArrayList<Integer>();
		roleIds.add(UserRoleEnum.ADMIN.getInt());
		roleIds.add(UserRoleEnum.USER.getInt());
		List<User> users = userDao.selectByRoleAndStatus(roleIds, activeIds);
		System.out.println("SelectByRoleAndStatus: roleIds:" + roleIds + ",activeIds:" + activeIds);
		for(User u : users){
			System.out.println(u);
		}
		
		activeIds.add(UserActiveStatusEnum.ACTIVE.getInt());
		users = userDao.selectByRoleAndStatus(roleIds, activeIds);
		System.out.println("SelectByRoleAndStatus: roleIds:" + roleIds + ",activeIds:" + activeIds);
		for(User u : users){
			System.out.println(u);
		}
	}
	
	/**
	 * <foreach /> @Param
	 */
	@Test
	public void testSelectByRoleAndStatus1() {
		List<Integer> roleIds = new ArrayList<Integer>();
		List<Integer> activeIds = new ArrayList<Integer>();
		roleIds.add(UserRoleEnum.ADMIN.getInt());
		roleIds.add(UserRoleEnum.USER.getInt());
		List<User> users = userDao.selectByRoleAndStatus1(roleIds, activeIds);
		System.out.println("SelectByRoleAndStatus1: roleIds:" + roleIds + ",activeIds:" + activeIds);
		for(User u : users){
			System.out.println(u);
		}
		
		activeIds.add(UserActiveStatusEnum.ACTIVE.getInt());
		users = userDao.selectByRoleAndStatus1(roleIds, activeIds);
		System.out.println("SelectByRoleAndStatus1: roleIds:" + roleIds + ",activeIds:" + activeIds);
		for(User u : users){
			System.out.println(u);
		}
	}
	
	/**
	 * <foreach /> map
	 */
	@Test
	public void testSelectByRoleAndStatus2() {
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		List<Integer> roleIds = new ArrayList<Integer>();
		List<Integer> activeIds = new ArrayList<Integer>();
		map.put("roleIds", roleIds);
		map.put("statusIds", activeIds);
		roleIds.add(UserRoleEnum.ADMIN.getInt());
		roleIds.add(UserRoleEnum.USER.getInt());
		List<User> users = userDao.selectByRoleAndStatus1(map);
		System.out.println("SelectByRoleAndStatus1: roleIds:" + roleIds + ",activeIds:" + activeIds);
		for(User u : users){
			System.out.println(u);
		}
		
		activeIds.add(UserActiveStatusEnum.ACTIVE.getInt());
		users = userDao.selectByRoleAndStatus1(map);
		System.out.println("SelectByRoleAndStatus1: roleIds:" + roleIds + ",activeIds:" + activeIds);
		for(User u : users){
			System.out.println(u);
		}
	}
	//test dynamic sql end

}
