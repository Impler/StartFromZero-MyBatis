package com.study.mybatis.resultHandler;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import com.study.mybatis.domain.Post;
/**
 * ResultHandler在遍历resultSet时被调用
 * 可以从当前resultContext中获取已获取的记录数、当前结果集对应的Java对象
 * 以及可以控制是否停止结果集继续遍历
 * @author Impler
 *
 */
public class PostResultHandler implements ResultHandler<Post> {

	@Override
	public void handleResult(ResultContext<? extends Post> resultContext) {
		System.out.print("PostResultHandler: ");
		System.out.println("resultCount: " + resultContext.getResultCount() + ",result: " + resultContext.getResultObject());
	}

}
