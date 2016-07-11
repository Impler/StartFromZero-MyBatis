package com.study.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.study.mybatis.domain.Post;

public interface PostDao extends BaseDao<Post, Integer>{

	/**
	 * 仅供测试，select one 返回多条数据将抛错
	 * @param id
	 * @return
	 */
	public Post selectOneByKey1(int id);
	
	/**
	 * 测试select list 结合rowbounds
	 * @param post
	 * @param ros
	 * @return
	 */
	public List<Post> selectListByRowBounds(Post post, RowBounds ros);
	
	/**
	 * 测试selectMap
	 * @param id
	 * @return
	 */
	public Map<Integer, Post> selectMapByKey(int id);
	
	/**
	 * 测试resultHandler
	 */
	public void selectResultHandler();
}
