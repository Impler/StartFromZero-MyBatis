package com.study.mybatis.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

/**
 * 抽象Dao，包含一般增删改查方法
 * 泛型 ：
 * T：dao接口；
 * E：实体对象
 * K：主键类型
 * @author Impler
 * @date 2016年4月18日
 */
public abstract class AbstractDao<T extends BaseDao<E, K>, E, K> implements BaseDao<E, K> {

	private Class<T> daoClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		//通过反射，获取泛型T的class对象
		daoClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T getDao(){
		// SqlSession是非线程安全的，应该避免作为类的静态或实例成员属性。SqlSession的作用范围应该是方法级的。
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
	public int delete(K key) {
		return getDao().delete(key);
	}
	@Override
	public List<E> select() {
		return getDao().select();
	}

	@Override
	public E selectOneByKey(K key) {
		return getDao().selectOneByKey(key);
	}

	@Override
	public List<E> selectByCondition(E entity) {
		return getDao().selectByCondition(entity);
	}
	
}
