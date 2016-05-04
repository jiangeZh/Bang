package com.xbmu.business;

public class FavoritesPostBean{
	private Integer user_id;
	private Integer post_id;

	// 无参数的构造器
	public FavoritesPostBean()
	{
	}
	// 初始化全部属性的构造器
	public FavoritesPostBean(Integer user_id, Integer post_id)
	{
		this.user_id = user_id;
		this.post_id = post_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getPost_id() {
		return post_id;
	}
	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}

	
}