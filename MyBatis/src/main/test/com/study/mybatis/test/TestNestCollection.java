package com.study.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.study.mybatis.dao.SqlSessionUtil;
import com.study.mybatis.domain.Region;

public class TestNestCollection {

	@Test
	public void test() {
		SqlSession session = SqlSessionUtil.getSession();
		List<Region> regions1 = session.selectList("region.queryRegions1");
		List<Region> regions2 = session.selectList("region.queryRegions2");
		
		for(int i=0; i<regions1.size(); i++){
			System.out.println(regions1.get(i));
			System.out.println(regions2.get(i));
			System.out.println("-------------------------");
		}
	
		System.out.println("regions1 equals regions2 : " + regions1.equals(regions2));
		System.out.println("regions1 == regions2 : " + (regions1 == regions2));
	}

}
