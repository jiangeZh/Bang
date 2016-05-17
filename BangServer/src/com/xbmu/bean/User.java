package com.xbmu.bean;

import java.io.Serializable;

/**
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `userpass` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `school_year` int(11) NOT NULL,
  `user_desc` varchar(50) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `concern_kind_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`),
  KEY `concern_kind_id` (`concern_kind_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`concern_kind_id`) REFERENCES `kind` (`kind_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
 */
//用户
public class User implements Serializable{
	private Integer user_id;
	private String username;
	private String userpass;
	private String email;
	private Integer school_year;
	private String user_desc;
	private Integer role; //0代表师弟师妹，1代表师兄师姐
	private Integer concern_kind_id;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer user_id, String username, String userpass, String email,
			Integer school_year, String user_desc, Integer role, Integer concern_kind_id) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.userpass = userpass;
		this.email = email;
		this.school_year = school_year;
		this.user_desc = user_desc;
		this.role = role;
		this.concern_kind_id = concern_kind_id;
	}
	public User(String username, String userpass, String email, Integer school_year, 
			String user_desc, Integer role, Integer concern_kind_id) {
		super();
		this.username = username;
		this.userpass = userpass;
		this.email = email;
		this.school_year = school_year;
		this.user_desc = user_desc;
		this.role = role;
		this.concern_kind_id = concern_kind_id;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username
				+ ", userpass=" + userpass + ", email=" + email + "]";
	}
		
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSchool_year() {
		return school_year;
	}
	public void setSchool_year(Integer school_year) {
		this.school_year = school_year;
	}
	public String getUser_desc() {
		return user_desc;
	}
	public void setUser_desc(String user_desc) {
		this.user_desc = user_desc;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Integer getConcern_kind_id() {
		return concern_kind_id;
	}
	public void setConcern_kind_id(Integer concern_kind_id) {
		this.concern_kind_id = concern_kind_id;
	}
	
}
