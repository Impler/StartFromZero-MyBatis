package com.study.mybatis.domain;

import java.util.Date;

import com.study.mybatis.commenum.UserActiveStatusEnum;
import com.study.mybatis.commenum.UserRoleEnum;

public class User {

	private int id;
	private String username;
	private String password;
	private String telNumber;
	private String email;
	private UserActiveStatusEnum active;
	private UserRoleEnum role;
	private Date createTime;
	
	public User() {
		super();
	}
	
	public User(Integer id, String username, String email) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserActiveStatusEnum getActive() {
		return active;
	}
	public void setActive(UserActiveStatusEnum active) {
		this.active = active;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public UserRoleEnum getRole() {
		return role;
	}
	public void setRole(UserRoleEnum role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", telNumber=" + telNumber
				+ ", email=" + email + ", active=" + active + ", role=" + role + ", createTime=" + createTime + "]";
	}
	
}
