package com.study.mybatis.dao.impl;

import java.util.List;

import com.study.mybatis.dao.AbstractDao;
import com.study.mybatis.dao.BookDao;
import com.study.mybatis.domain.Book;

public class BookDaoImpl extends AbstractDao<BookDao, Book, Integer> implements BookDao {

	@Override
	public List<Book> selectByNestedSelect() {
		return super.getDao().selectByNestedSelect();
	}

	@Override
	public List<Book> selectByNestedResult() {
		return super.getDao().selectByNestedResult();
	}

	@Override
	public List<Book> selectByProcedure() {
		return super.getDao().selectByProcedure();
	}

}
