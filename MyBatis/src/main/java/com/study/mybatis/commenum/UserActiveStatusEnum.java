package com.study.mybatis.commenum;

/**
 * 用户状态枚举
 * 
 * @author Impler
 * @date 2016年4月16日
 */
public enum UserActiveStatusEnum implements IGenericEnum{
	// 未激活状态
	INACTIVE(0, "inactive"),
	// 已激活状态
	ACTIVE(1, "active");

	private final int key;
	private final String value;

	private UserActiveStatusEnum(int key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int getInt() {
		return key;
	}

	@Override
	public String getString() {
		return this.value;
	}
}
