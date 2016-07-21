package com.study.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import com.study.mybatis.commenum.IGenericEnum;
import com.study.mybatis.commenum.util.EnumUtil;

/**
 * 一般枚举类型（形如E(1, "e")）通用类型转换处理类
 * @author Impler
 * @date 2016年4月16日
 */
public class GenericEnumHandler<E extends IGenericEnum> extends BaseTypeHandler<E> {

	private Class<E> type;

	public GenericEnumHandler(Class<E> type) {
		if (type == null) {
			throw new IllegalArgumentException("Type argument cannot be null");
		}
		this.type = type;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.getIntValue());
	}

	@Override
	public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
		if (rs.wasNull()) {
			return null;
		} else {
			int key = rs.getInt(columnName);
			return EnumUtil.getEnumConstant(type, key);
		}
	}

	@Override
	public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		if (rs.wasNull()) {
			return null;
		} else {
			int key = rs.getInt(columnIndex);
			return EnumUtil.getEnumConstant(type, key);
		}
	}

	@Override
	public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		if (cs.wasNull()) {
			return null;
		} else {
			int key = cs.getInt(columnIndex);
			return EnumUtil.getEnumConstant(type, key);
		}
	}
}
