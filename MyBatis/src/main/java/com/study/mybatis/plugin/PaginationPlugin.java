package com.study.mybatis.plugin;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * 自定义插件（拦截器）
 * Executor代理类
 * 代理query方法
 * Executor接口中存在两个重载的query方法，
 * <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, CacheKey cacheKey, BoundSql boundSql) throws SQLException;
 * <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler) throws SQLException;
 * 其默认实现BaseExecutor中，外部调用第一个query方法，该方法中调用了自己的另一个重载方法
 * 根据动态代理的原理，代理类调用方法时才会走代理方法，被代理类内部的方法调用，即便是接口方法，也不会走代理方法
 * 因此这里只能拦截第一个query方法
 * @author impler
 *
 */
@Intercepts(@Signature(args = { MappedStatement.class, Object.class,
		RowBounds.class, ResultHandler.class }, method = "query", type = Executor.class))
public class PaginationPlugin implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println(PaginationPlugin.class.getName() + ".intercept" + invocation);
		return invocation.proceed();
	}

	// 生成代理对象
	@Override
	public Object plugin(Object target) {
		System.out.println(PaginationPlugin.class.getName() + ".plugin "
				+ target);
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		System.out.println(PaginationPlugin.class.getName() + ".setProperties "
				+ properties);
	}
}
