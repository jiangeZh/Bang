package com.xbmu.business;

public class FavoritesResBean{
	private Integer user_id;
	private Integer res_id;

	// 无参数的构造器
	public FavoritesResBean()
	{
	}
	// 初始化全部属性的构造器
	public FavoritesResBean(Integer user_id, Integer res_id)
	{
		this.user_id = user_id;
		this.setRes_id(res_id);
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getRes_id() {
		return res_id;
	}
	public void setRes_id(Integer res_id) {
		this.res_id = res_id;
	}
}