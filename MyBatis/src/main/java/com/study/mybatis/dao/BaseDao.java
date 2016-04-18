package com.study.mybatis.dao;

import java.util.List;

public interface BaseDao<T, K> {

	public int insert(T entity);
	public int update(T entity);
	public int delete(K key);
	public List<T> select();
	public T selectOneByKey(K key);
}
