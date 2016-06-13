package com.study.mybatis.dao;

import java.util.List;

import com.study.mybatis.domain.Book;

public interface BookDao extends BaseDao<Book, Integer>{

	/**
	 * Mybatis处理级联数据的两种方式
	 */
	/**
	 * 1 使用内嵌select
	 * @return
	 */
	public List<Book> selectBookAndAuthorByNestedSelect();
	
	/**
	 * 2 使用连接查询级联数据
	 * @return
	 */
	public List<Book> selectBookAndAuthorByNestedResult();
	
	/**
	 * 
	 * @return
	 */
	public List<Book> selectBookAndAuthorByProcedure();
	
	/**
	 * 
	 * @return
	 */
	public List<Book> selectBookAndPostsByNestedSelect();
	
	/**
	 * 
	 * @return
	 */
	public List<Book> selectBookAndPostsByNestedResult();
}