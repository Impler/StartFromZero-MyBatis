package com.study.mybatis.dao.impl;

import java.util.List;

import com.study.mybatis.dao.AbstractDao;
import com.study.mybatis.dao.BookDao;
import com.study.mybatis.domain.Book;

public class BookDaoImpl extends AbstractDao<BookDao, Book, Integer> implements BookDao {

	@Override
	public Book selectBookAndAuthorByNestedSelect(int bookId) {
		return super.getDao().selectBookAndAuthorByNestedSelect(bookId);
	}

	@Override
	public Book selectBookAndAuthorByNestedResult(int bookId) {
		return super.getDao().selectBookAndAuthorByNestedResult(bookId);
	}

	@Override
	public List<Book> selectBookAndAuthorByProcedure(int authorId) {
		return super.getDao().selectBookAndAuthorByProcedure(authorId);
	}

	@Override
	public Book selectBookAndPostsByNestedSelect(int bookId) {
		return super.getDao().selectBookAndPostsByNestedSelect(bookId);
	}

	@Override
	public Book selectBookAndPostsByNestedResult(int bookId) {
		return super.getDao().selectBookAndPostsByNestedResult(bookId);
	}

}
