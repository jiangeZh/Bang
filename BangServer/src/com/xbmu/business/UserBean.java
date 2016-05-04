package com.xbmu.business;

public class UserBean{
	private Integer userId;
	private String userName;
	private String email;
	private Integer schoolYear;
	private String userDesc;
	private Integer role; //0代表师弟师妹，1代表师兄师姐
	private Integer concernKindId;

	// 无参数的构造器
	public UserBean()
	{
	}
	// 初始化全部属性的构造器
	public UserBean(String userName, String email,
			Integer schoolYear, String userDesc, Integer role, Integer concernKindId) {
		this.userName = userName;
		this.email = email;
		this.schoolYear = schoolYear;
		this.userDesc = userDesc;
		this.role = role;
		this.concernKindId = concernKindId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(Integer schoolYear) {
		this.schoolYear = schoolYear;
	}
	public String getUserDesc() {
		return userDesc;
	}
	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Integer getConcernKindId() {
		return concernKindId;
	}
	public void setConcernKindId(Integer concernKindId) {
		this.concernKindId = concernKindId;
	}

}