package com.study.mybatis.spring.sqlSessionTemplate;

import org.springframework.stereotype.Repository;

import com.study.mybatis.domain.User;
import com.study.mybatis.spring.dao.UserDao;
import com.study.mybatis.spring.sqlSessionTemplate.AbstractDao;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<UserDao, User, Integer> implements UserDao{

}
