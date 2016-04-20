package com.study.mybatis.test;

import java.util.List;

import org.junit.Test;

import com.study.mybatis.dao.BookDao;
import com.study.mybatis.dao.impl.BookDaoImpl;
import com.study.mybatis.domain.Book;

public class TestMyBatisAdvancedQuery {

	private BookDao bookDao = new BookDaoImpl();
	
	@Test
	public void testSelectByNestedSelect(){
		List<Book> books = bookDao.selectByNestedSelect();
		for(Book book : books){
			System.out.println(book);
		}
	}
	
	@Test
	public void testSelectByNestedResult(){
		List<Book> books = bookDao.selectByNestedResult();
		for(Book book : books){
			System.out.println(book);
		}
	}
	
	/**
	 * 实验未成功
	 * TODO
	 */
	@Test
	public void testSelectByProcedure(){
		List<Book> books = bookDao.selectByProcedure();
		for(Book book : books){
			System.out.println(book);
		}
	}
}
