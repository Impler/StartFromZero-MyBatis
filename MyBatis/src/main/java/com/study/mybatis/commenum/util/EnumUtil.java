package com.study.mybatis.commenum.util;

import com.study.mybatis.commenum.IGenericEnum;

/**
 * 枚举类工具类
 * @author Impler
 * @date 2016年4月16日
 */
public class EnumUtil {

	/**
	 * 根据枚举常量的int值，取得对应的枚举对象
	 * @param type 枚举类class
	 * @param key int值
	 * @return
	 */
	public static <E extends IGenericEnum> E getEnumConstant(Class<E> type, int key){
		E[] constants = type.getEnumConstants();
		if(null == constants){
			return null;
		}
		for(E c : constants){
			if(c.getIntValue() == key){
				return c;
			}
		}
		return null;
	}
}
