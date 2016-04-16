package com.study.mybatis.commenum;

/**
 * 用户角色枚举
 * @author Impler
 * @date 2016年4月16日
 */
public enum UserRoleEnum implements IGenericEnum{

	SUPERADMIN(1, "superadmin"),
	ADMIN(2, "admin"),
	USER(3, "user");
	
	private final int roleId;
	private final String roleName;
	
	private UserRoleEnum(int roleId, String roleName){
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	@Override
	public int getInt() {
		return roleId;
	}

	@Override
	public String getString() {
		return roleName;
	}

}
