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
	public Book selectBookAndAuthorByNestedSelect(int bookId);
	
	/**
	 * 2 使用连接查询级联数据
	 * @return
	 */
	public Book selectBookAndAuthorByNestedResult(int bookId);
	
	/**
	 * 
	 * @return
	 */
	public List<Book> selectBookAndAuthorByProcedure(int authorId);
	
	/**
	 * 
	 * @return
	 */
	public Book selectBookAndPostsByNestedSelect(int bookId);
	
	/**
	 * 
	 * @return
	 */
	public Book selectBookAndPostsByNestedResult(int bookId);
}
