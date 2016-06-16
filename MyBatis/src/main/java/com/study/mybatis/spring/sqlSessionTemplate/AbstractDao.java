package com.study.mybatis.spring.sqlSessionTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.study.mybatis.dao.BaseDao;

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
	
	@Autowired
	// SqlSessionTemplate对象
	private SqlSession sqlSession;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		//通过反射，获取泛型T的class对象
		daoClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T getDao(){
		return sqlSession.getMapper(daoClass);
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
