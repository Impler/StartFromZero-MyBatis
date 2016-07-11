package com.study.mybatis.domain;

/**
 * 书评模型
 * @author Impler
 * @date 2016年4月20日
 */
public class Post {

	private int id;
	private String username;
	private String postContent;
	private Book book;
	
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
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", username=" + username + ", postContent="
				+ postContent + ", book=" + book + "]";
	}
	
}
