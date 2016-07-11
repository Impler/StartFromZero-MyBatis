package com.study.mybatis.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;

import com.study.mybatis.dao.PostDao;
import com.study.mybatis.dao.impl.PostDaoImpl;
import com.study.mybatis.domain.Post;

public class TestMyBatisExecuteMethod {

	PostDao dao = new PostDaoImpl();
	
	@Test
	public void testSelectOne() {
		Post p = dao.selectOneByKey(1);
		System.out.println("testSelectOne: " + p);
	}
	
	/**
	 * 将会抛出org.apache.ibatis.exceptions.TooManyResultsException异常
	 */
	@Test(expected=TooManyResultsException.class)
	public void testSelectOne1() {
		Post p = dao.selectOneByKey1(1);
		System.out.println("testSelectOne1: " + p);
	}

	@Test
	public void testSelectList(){
		Post p = new Post();
		p.setId(1);
		List<Post> ps = dao.selectByCondition(p);
		for(Post po : ps){
			System.out.println("testSelectList: " + po);
		}
	}
	@Test
	public void testSelectListWithRowBounds(){
		Post p = new Post();
		p.setId(1);
		//从结果集的第四条记录开始，查询2条记录
		RowBounds row = new RowBounds(3, 2);
		List<Post> ps = dao.selectListByRowBounds(p, row);
		for(Post po : ps){
			System.out.println("testSelectListWithRowBounds: " + po);
		}
	}
	
	@Test
	public void testSelectMap(){
		Map<Integer, Post> map = dao.selectMapByKey(1);
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()){
			Integer key = it.next();
			System.out.println("testSelectMap: key:" + key + "<->" + map.get(key));
		}
	}
	
	@Test
	public void testResultHandler(){
		dao.selectResultHandler();
	}
}
