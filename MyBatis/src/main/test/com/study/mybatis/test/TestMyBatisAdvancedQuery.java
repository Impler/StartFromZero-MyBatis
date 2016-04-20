package com.study.mybatis.test;

import java.util.List;

import org.junit.Test;

import com.study.mybatis.dao.BookDao;
import com.study.mybatis.dao.impl.BookDaoImpl;
import com.study.mybatis.domain.Book;

public class TestMyBatisAdvancedQuery {

	private BookDao bookDao = new BookDaoImpl();
	
	//处理多对一/has-a问题 s
	@Test
	public void testSelectBookAndAuthorByNestedSelect(){
		List<Book> books = bookDao.selectBookAndAuthorByNestedSelect();
		for(Book book : books){
			System.out.println(book);
		}
	}
	
	@Test
	public void testSelectBookAndAuthorByNestedResult(){
		List<Book> books = bookDao.selectBookAndAuthorByNestedResult();
		for(Book book : books){
			System.out.println(book);
		}
	}
	
	/**
	 * 使用存储过程返回多个结果集，再映射
	 */
	@Test
	public void testSelectBookAndAuthorByProcedure(){
		List<Book> books = bookDao.selectBookAndAuthorByProcedure();
		for(Book book : books){
			System.out.println(book);
		}
	}
	//处理多对一/has-a问题 e
	
	//处理一对多问题 s
	@Test
	public void testSelectBookAndPostsByNestedSelect(){
		List<Book> books = bookDao.selectBookAndPostsByNestedSelect();
		for(Book book : books){
			System.out.println(book);
		}
	}

	@Test
	public void testSelectBookAndPostsByNestedResult(){
		List<Book> books = bookDao.selectBookAndPostsByNestedResult();
		for(Book book : books){
			System.out.println(book);
		}
	}
	
	//处理一对多问题 e
	
}
