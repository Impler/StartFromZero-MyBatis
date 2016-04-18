package com.study.mybatis.dao;

import java.util.List;

public interface BaseDao<T, K> {

	/**
	 * 插入一条记录
	 * @param entity
	 * @return 影响行数
	 */
	public int insert(T entity);
	/**
	 * 根据主键修改一条记录
	 * @param entity
	 * @return 影响行数
	 */
	public int update(T entity);
	/**
	 * 根据主键删除一条记录
	 * @param key
	 * @return 影响行数
	 */
	public int delete(K key);
	/**
	 * 查询所有记录
	 * @return 实体对象集合
	 */
	public List<T> select();
	/**
	 * 根据主键查询记录
	 * @param key
	 * @return 实体对象
	 */
	public T selectOneByKey(K key);
	/**
	 * 模糊查询
	 * @param entity
	 * @return 实体对象集合
	 */
	public List<T> selectByCondition(T entity);
}
