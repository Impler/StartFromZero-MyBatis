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
		int bookId = 1;
		Book book = bookDao.selectBookAndAuthorByNestedSelect(bookId);
		System.out.println("testSelectBookAndAuthorByNestedSelect:" + book);
	}
	
	@Test
	public void testSelectBookAndAuthorByNestedResult(){
		int bookId = 1;
		Book book = bookDao.selectBookAndAuthorByNestedResult(bookId);
		System.out.println("testSelectBookAndAuthorByNestedResult: " + book);
	}
	
	/**
	 * 使用存储过程返回多个结果集，再映射
	 */
	@Test
	public void testSelectBookAndAuthorByProcedure(){
		int authorId = 3;
		List<Book> books = bookDao.selectBookAndAuthorByProcedure(authorId);
		for(Book book : books){
			System.out.println("testSelectBookAndAuthorByProcedure: " + book);
		}
	}
	//处理多对一/has-a问题 e
	
	//处理一对多问题 s
	@Test
	public void testSelectBookAndPostsByNestedSelect(){
		int bookId = 1;
		Book book = bookDao.selectBookAndPostsByNestedSelect(bookId);
		System.out.println("testSelectBookAndPostsByNestedSelect: " + book);
	}

	@Test
	public void testSelectBookAndPostsByNestedResult(){
		int bookId = 1;
		Book book = bookDao.selectBookAndPostsByNestedResult(bookId);
		System.out.println("testSelectBookAndPostsByNestedResult: " + book);
	}
	
	//处理一对多问题 e
	
}
