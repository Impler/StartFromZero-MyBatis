package com.study.mybatis.commenum;

/**
 * 一般枚举类型（形如E(1, "e")）接口，作为ibatis类型转换辅助
 * @author Impler
 * @date 2016年4月16日
 */
public interface IGenericEnum {
	/**
	 * 获得枚举整型部分值
	 * @return
	 */
	public int getInt();
	/**
	 * 获取枚举描述信息
	 * @return
	 */
	public String getString();
}
