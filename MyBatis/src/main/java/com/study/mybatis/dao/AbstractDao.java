package com.study.mybatis.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.ibatis.session.SqlSession;


public abstract class AbstractDao<T extends BaseDao<E>, E> implements BaseDao<E> {

	private Class<T> daoClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		//通过反射，获取泛型T的class对象
		daoClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T getDao(){
		SqlSession session =  SqlSessionUtil.getSession();
		return session.getMapper(daoClass);
	}
	@Override
	public int insert(E entity) {
		return getDao().insert(entity);
	}
	@Override
	public int update(E entity) {
		return getDao().update(entity);
	}
	@Override
	public int delete(E entity) {
		return getDao().delete(entity);
	}
	@Override
	public List<E> select() {
		return getDao().select();
	}
	
	
}
