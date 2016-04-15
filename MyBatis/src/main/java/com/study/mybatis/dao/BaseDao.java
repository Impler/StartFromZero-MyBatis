package com.study.mybatis.dao;

import java.util.List;

public interface BaseDao<T> {

	public int insert(T entity);
	public int update(T entity);
	public int delete(T entity);
	public List<T> select();
}
