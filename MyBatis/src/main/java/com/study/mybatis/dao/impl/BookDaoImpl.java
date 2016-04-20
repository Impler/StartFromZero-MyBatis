package com.study.mybatis.dao.impl;

import java.util.List;

import com.study.mybatis.dao.AbstractDao;
import com.study.mybatis.dao.BookDao;
import com.study.mybatis.domain.Book;

public class BookDaoImpl extends AbstractDao<BookDao, Book, Integer> implements BookDao {

	@Override
	public List<Book> selectBookAndAuthorByNestedSelect() {
		return super.getDao().selectBookAndAuthorByNestedSelect();
	}

	@Override
	public List<Book> selectBookAndAuthorByNestedResult() {
		return super.getDao().selectBookAndAuthorByNestedResult();
	}

	@Override
	public List<Book> selectBookAndAuthorByProcedure() {
		return super.getDao().selectBookAndAuthorByProcedure();
	}

	@Override
	public List<Book> selectBookAndPostsByNestedSelect() {
		return super.getDao().selectBookAndPostsByNestedSelect();
	}

	@Override
	public List<Book> selectBookAndPostsByNestedResult() {
		return super.getDao().selectBookAndPostsByNestedResult();
	}

}
