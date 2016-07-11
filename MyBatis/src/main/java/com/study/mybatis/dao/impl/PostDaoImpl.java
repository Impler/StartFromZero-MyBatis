package com.study.mybatis.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.study.mybatis.dao.PostDao;
import com.study.mybatis.dao.SqlSessionUtil;
import com.study.mybatis.domain.Post;
import com.study.mybatis.resultHandler.PostResultHandler;
/**
 * test by execute method
 * @author Impler
 *
 */
public class PostDaoImpl implements PostDao {

	@Override
	public int insert(Post entity) {
		return 0;
	}

	@Override
	public int update(Post entity) {
		return 0;
	}

	@Override
	public int delete(Integer key) {
		return 0;
	}

	@Override
	public List<Post> select() {
		return null;
	}

	@Override
	public Post selectOneByKey(Integer key) {
		return SqlSessionUtil.getSession().selectOne("com.study.mybatis.dao.PostDao.selectByKey", key);
	}
	/**
	 * selectOneByKey1 测试 返回多条数据
	 * 将会抛出org.apache.ibatis.exceptions.TooManyResultsException异常
	 */
	@Override
	public Post selectOneByKey1(int id) {
		return SqlSessionUtil.getSession().selectOne("com.study.mybatis.dao.PostDao.selectByKey1", id);
	}

	@Override
	public List<Post> selectByCondition(Post entity) {
		return SqlSessionUtil.getSession().selectList("com.study.mybatis.dao.PostDao.selectByCondition", entity);
	}

	@Override
	/**
	 * RowBounds的方式并不是完全意义上的数据库层面的分页，而是把结果集查出来，通过结果集下标匹配RowBounds范围
	 */
	public List<Post> selectListByRowBounds(Post post, RowBounds ros) {
		return SqlSessionUtil.getSession().selectList("com.study.mybatis.dao.PostDao.selectByCondition", post, ros);
	}

	@Override
	/**
	 * 测试selectMap
	 */
	public Map<Integer, Post> selectMapByKey(int id) {
		return SqlSessionUtil.getSession().selectMap("com.study.mybatis.dao.PostDao.selectByKey", id, "id");
	}

	@Override
	/**
	 * test resultHandler
	 */
	public void selectResultHandler() {
		SqlSessionUtil.getSession().select("com.study.mybatis.dao.PostDao.selectByCondition", 1, new PostResultHandler());
	}


}
